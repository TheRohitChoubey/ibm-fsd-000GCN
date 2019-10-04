import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Interfaces/User';
import { Project } from 'src/app/Interfaces/Project';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { strictEqual } from 'assert';
@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {
  users: User[]
  projects: Project
  pnames: pnames[]
  proid: Number
  manager: string
  manageremail: string
  uNames: userName[]
 

  newTaskForm: FormGroup
  constructor() {

    
    
    this.manageremail = localStorage.getItem("email");
    this.manager = localStorage.getItem("manager");
    console.log(this.manageremail);
    this.newTaskForm = new FormGroup({
      taskName: new FormControl("",[Validators.required]),
      startDate: new FormControl("",[Validators.required]),
      endDate: new FormControl("",[Validators.required]),
      status: new FormControl("",[Validators.required])
    })
  }

  ngOnInit() {
    console.log(this.manageremail);
    const _baseUrl = `http://b4ibm21.iiht.tech:8001/`;
    const url = `http://b4ibm21.iiht.tech:8010/`;
    fetch(_baseUrl + `/user/getalluser`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => res.json())
      .then(res => {
        this.users = res;
        console.log(res);
        fetch(url + `/findbyemail/${this.manageremail}`, {
          method: "GET",
          headers:
          {
            "Content-Type": "application/json"
          }
        }).then(resp => resp.json())
          .then(resp => {
            this.projects = resp;
            console.log(resp);
            this.ints()
          })

      })
  }
  ints() {
    this.uNames = [];
    console.log(this.users);
    for (let i = 0; i < this.users.length; i++) {

      let uDetails = { email: this.users[i].email, name: this.users[i].username }
      this.uNames[i] = (uDetails);

    }

    this.proid = this.projects.projectId;
    console.log(this.projects);
    console.log(this.proid);
  }
  submit() {
    let taskName = this.newTaskForm.value.taskName;

    let startDate = this.newTaskForm.value.startDate;
    let endDate = this.newTaskForm.value.endDate;
    let status = this.newTaskForm.value.status;
    let taskdetails = [];
    taskdetails.push({ taskName: taskName, startDate: startDate, endDate: endDate, status: status, projectId: this.proid });
    const _baseUrl = `http://b4ibm21.iiht.tech:8010`;
    console.log(taskdetails);
    fetch(_baseUrl + `/projects/tasks`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(taskdetails)
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
      });
  }
}
interface userName {
  email: String
  name: String
}
interface pnames {
  projectid: Number
  pname: String
  pmanageremail: String
}
