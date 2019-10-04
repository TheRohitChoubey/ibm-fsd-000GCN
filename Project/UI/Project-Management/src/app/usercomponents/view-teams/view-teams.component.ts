import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user/User';
import { Project } from 'src/app/Interfaces/Project';

@Component({
  selector: 'app-view-teams',
  templateUrl: './view-teams.component.html',
  styleUrls: ['./view-teams.component.css']
})
export class ViewTeamsComponent implements OnInit {

  email: String
  users: User[]
  user:User
  teams:User
  project:Project

  constructor() {
    this.user = {
      username: "",
      password: "",
      ulocation: "",
      availability: "",
      email: "",
      udomain: "",
      previous_project: "",
      userType: "",
      projectid: "",
      taskId: ""
    } 
  }

  ngOnInit() {    
    this.email = localStorage.getItem("email");
    console.log(this.email);
    const _baseUrl = `http://b4ibm21.iiht.tech:8001`;
    fetch(_baseUrl + `/user/${this.email}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(res => {
        this.user = res;
        let taskUrl = `http://b4ibm21.iiht.tech:8001`
        fetch(taskUrl + `/getAllTeam/${this.user.taskId}`,{
          method: "GET",
          headers:{
            "Content-Type":"application/json"
          }
        }).then(res=>res.json())
          .then(data=>{
               this.users=data;
               console.log(this.users);
          })
      })
  }

}
