import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from 'src/app/user/User';
import { Tasks } from 'src/app/Interfaces/Tasks';

@Component({
  selector: 'app-add-team',
  templateUrl: './add-team.component.html',
  styleUrls: ['./add-team.component.css']
})
export class AddTeamComponent implements OnInit {
  role: string
  users: User[]
  uNames: userName[]
  manager: string
  projectId: string
  tName: tDetail[]
  tasks: tDetail[]
  newTeamForm: FormGroup

  constructor() {
    this.role = "user"
    this.newTeamForm = new FormGroup({
      uemail: new FormControl(""),
      uassigndate: new FormControl(""),
      taskName: new FormControl("")
    })
  }

  ngOnInit() {
    this.manager = localStorage.getItem("email");
    const _baseUrl = `http://localhost:8001`;
    const projectUrl = `http://b4ibm21.iiht.tech:8010`;
    const taskUrl = `http://b4ibm21.iiht.tech:8021`;
    
    fetch(_baseUrl + `/user/role/user`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(res => {
        this.users = res;
        this.uNames = [];
        console.log(this.users);
        for (let i = 0; i < this.users.length; i++) {
          let uDetails = {
            email: this.users[i].email,
            name: this.users[i].username
          }
          this.uNames[i] = (uDetails);
        }
      })

    fetch(projectUrl + `/findbyemail/${this.manager}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(res => {
        this.projectId = res.projectId;

        fetch(taskUrl + `/getAllTasks/${this.projectId}`, {
          method: "GET",
          headers: {
            "Content-Type": "application/json"
          }
        })
          .then(res => res.json())
          .then(res => {
            this.tasks = res;
            this.getTaskName();

          })

      })
  }

  getTaskName(){
    this.tName =[];
    console.log(this.tasks);
    for(let j=0; j<this.tasks.length; j++){
        let taskDetail= {
          taskName: this.tasks[j].taskName,
          taskId: this.tasks[j].taskId
        }
        this.tName.push(taskDetail);
    }
    console.log(this.tName)
    
  }


    submit() {
    let email = this.newTeamForm.value.uemail;
    let assigndate = this.newTeamForm.value.uassigndate;
    let taskId = this.newTeamForm.value.taskName;

    
    let teamDetails = [];
    teamDetails.push({ uemail: email,uassigndate: assigndate, taskId: taskId,projectId : this.projectId });
    const taskUrl = `http://b4ibm21.iiht.tech:8021`;
    console.log(teamDetails);
    fetch(taskUrl + "/tasks/team", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(teamDetails)
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
      })
  }

}

interface userName {
  email: String
  name: String
}

interface tDetail {
  taskName: string
  taskId: Number
}