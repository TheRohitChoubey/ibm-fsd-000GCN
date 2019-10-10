import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Interfaces/User';
import { Project } from 'src/app/Interfaces/Project';
import { Tasks } from 'src/app/Interfaces/Tasks';

@Component({
  selector: 'app-view-tasks',
  templateUrl: './view-tasks.component.html',
  styleUrls: ['./view-tasks.component.css']
})
export class ViewTasksComponent implements OnInit {

  email: String
  users: User
  project: Project
  task: Tasks[]

  constructor() {
    this.users = {
      username: "",
      password: "",
      ulocation: "",
      availability: "",
      email: "",
      udomain: "",
      previous_project: "",
      userType: "",
      projectid: "",
      taskId: "",
      uStatus : ""
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
        this.users = res;
        const _task = `http://b4ibm21.iiht.tech:8021`;
        fetch(_task + `/getAllTasks/${this.users.projectid}`, {
          method: "GET",
          headers: {
            "Content-Type": "application/json"
          }
        }).then(response => response.json())
          .then(ta => {
            this.task = ta;
          })

      })
  }

}
