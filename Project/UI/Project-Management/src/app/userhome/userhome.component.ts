import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../Interfaces/User';
import { Tasks } from '../Interfaces/Tasks';
import { Project } from '../Interfaces/Project';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  userName: any
  email: string
  userRecord: User
  userTask: Tasks
  userProject: Project
  completed:number
  notCompleted:number
  constructor(private userService: UserService) {
    this.userRecord = {
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

    this.userProject = {
      projectId: 0,
      pname: "",
      plocation: "",
      start_date: "",
      end_date: "",
      pmanagerEmail: ""
    }

    this.userTask = {
      taskId : 0,
      taskName: "",
      startDate: "",
      endDate: "",
      status: "",
      projectId: 0
    }
  }


  public doughnutLables = ['Task-Completed', 'Reamaining-Task'];
  public doughnutChartType = 'doughnut';
  public doughnutData = [, ];


  ngOnInit() {
    this.email = localStorage.getItem("email");
    console.log(this.email);
    const userUrl = `http://b4ibm21.iiht.tech:8001`;
    const taskUrl = `http://b4ibm21.iiht.tech:8021`;
    const projectUrl = `http://b4ibm21.iiht.tech:8010`;
    fetch(userUrl + `/user/${this.email}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(res => {
        this.userRecord = res;
        console.log(this.userRecord);
        fetch(projectUrl + `/findbyid/${this.userRecord.projectid}`, {
          method: "GET",
          headers: {
            "Content-Type": "application/json"
          }
        })
          .then(res => res.json())
          .then(res => {
            this.userProject = res;
            console.log(this.userProject);
            this.completed=parseInt(this.userRecord.uStatus);
            this.notCompleted=100-this.completed;
            this.doughnutData=[this.completed,this.notCompleted];
            fetch(taskUrl + `/taskById/${this.userRecord.taskId}`, {
              method: "GET",
              headers: {
                "Content-Type": "application/json"
              }
            })
              .then(res => res.json())
              .then(res => {
                this.userTask = res;
                console.log(this.userTask);
              })

          })
      })
  }

  update(){

    const _baseUrl = `http://b4ibm21.iiht.tech:8001/`;
  
    fetch(_baseUrl + `/update/${this.userRecord.email}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(this.userRecord)
    }).then(res => res.json())
      .then(data => {
  
        alert("Profile-Updated");
  
      })
    document.getElementById("close").click();
    document.location.reload();
  
  }

  updateStatus() {
    const userUrl = `http://b4ibm21.iiht.tech:8001`;
    const taskUrl = `http://b4ibm21.iiht.tech:8021`;
    const projectUrl = `http://b4ibm21.iiht.tech:8010`;
    document.getElementById("closeStatus").click();

    let status = this.userTask.status;

    fetch(userUrl + `/user/${this.email}/${status}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
        alert("Task Status updated succesfully");
      });
      document.getElementById("closeStatus").click();
      document.location.reload();

  }

}
