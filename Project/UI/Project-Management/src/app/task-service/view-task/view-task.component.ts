import { Component, OnInit } from '@angular/core';
import { Tasks } from 'src/app/Interfaces/Tasks';
import { Project } from 'src/app/Interfaces/Project';
import { User } from 'src/app/Interfaces/User';
import { Router } from "@angular/router";
@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {
  tasks: Tasks[]
  task: Taskraedonlyproject
  uNames: userName[]
  users: User[]
  proid: Number
  manager: string
  projects: Project
  pname: Project[]
  id: Number;
  constructor(private router: Router) {
    this.task = {
      taskName: "",
      startDate: "",
      endDate: "",
      status: ""
    };
  }

  ngOnInit() {

    this.manager = localStorage.getItem("email");
    const url = `http://b4ibm21.iiht.tech:8010/`;
    const taskUrl = `http://b4ibm21.iiht.tech:8021`;
    fetch(url + `/findbyemail/${this.manager}`, {
      method: "GET",
      headers:
      {
        "Content-Type": "application/json"
      }
    }).then(resp => resp.json())
      .then(resp => {
        this.projects = resp;
        console.log(resp);
        this.proid = this.projects.projectId;
        fetch(taskUrl + `/getAllTasks/${this.proid}`, {
          method: "GET",
          headers: {
            "Content-Type": "application/json"
          }
        })
          .then(res => res.json())
          .then(data => {
            this.tasks = data;
            console.log(this.tasks);
          })
      })

  }
  updateForm(id) {


    const _baseUrl = `http://b4ibm21.iiht.tech:8001/`;
    const url = `http://b4ibm21.iiht.tech:8021`;
    fetch(url + `/taskById/${id}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => res.json())
      .then(data => {

        this.task = data;
        fetch(_baseUrl + `/user/getalluser`, {
          method: "GET",
          headers: {
            "Content-Type": "application/json"
          }
        }).then(res => res.json())
          .then(res => {
            this.users = res;
            this.form();
          })


      })

  }

  update() {
    const url = `http://b4ibm21.iiht.tech:8021`;

    let newtask = [];
    newtask.push({
      taskName: this.task.taskName,
      startDate: this.task.startDate,
      endDate: this.task.endDate,
      status: this.task.status
    })
    console.log(newtask);


    fetch(url + "/updateTask", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(newtask)
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
      });
    document.getElementById("updateclose").click();
    document.location.reload();
  }

  delete(id) {
    const url = `http://b4ibm21.iiht.tech:8021`;
    fetch(url + `/deleteTask/${id}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => res.json)
      .then(res => {
        if (res) {
          alert("task is removed");
        }
        this.router.navigate(['taskService/view'])

        document.location.reload();
      })
  }
  form() {
    document.getElementById("toggle").click();
  }

}
interface userName {
  email: String
  name: String
}
interface proid {
  projectid: number
}
interface Taskraedonlyproject {
  taskName: string,
  startDate: string,
  endDate: string,
  status: string,
}
