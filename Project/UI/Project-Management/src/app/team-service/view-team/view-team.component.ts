import { Component, OnInit } from '@angular/core';
import { Tasks } from 'src/app/Interfaces/Tasks';
import { User } from 'src/app/Interfaces/User';
import { Project } from 'src/app/Interfaces/Project';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-team',
  templateUrl: './view-team.component.html',
  styleUrls: ['./view-team.component.css']
}) export class ViewTeamComponent implements OnInit {
  tasks: TasksDetail[]
  task: TasksDetail
  uNames: userName[]
  users: User[]
  proid: Number
  manager: string
  projects: Project
  pname: Project[]
  id: Number;
  constructor(private router: Router) {
    this.task = {
      taskId: 0,
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
     
             let details = {
               projectId : this.proid,
               taskIDs : [{}]
            }

          

            let j= 0;
            for (let i = 0; i < this.tasks.length; i++) {
              details.taskIDs[j++] = (this.tasks[i].taskId);
            }

            console.log(details);
            fetch(`http://b4ibm21.iiht.tech:8001/findUserProjectTask/`, {
              method: "POST",
              headers: {
                "Content-Type": "application/json"
              },
              body: JSON.stringify(details)
            })
              .then(res => res.json())
              .then(data => {
                console.log(data);
                this.users = data;
                console.log(this.users);
              })
          })
      })
  }



  delete(email) {
    const url = `http://b4ibm21.iiht.tech:8001`;
    fetch(url + `/deleteTeamMember/${email}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => res.json)
      .then(res => {
        if (res) {
          alert("User is Removed from this task");
        }
        this.router.navigate(['teamService/view'])

        document.location.reload();
      })
  }


}

interface userName {
  email: String
  name: String
}
interface proid {
  projectid: number
}
interface TasksDetail {
  taskId: Number,
  taskName: string,
  startDate: string,
  endDate: string,
  status: string,
}
