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
      taskId: ""
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
      taskName: "",
      startDate: "",
      endDate: "",
      status: "",
      projectId: 0
    }
  }


  public doughnutLables = ['Task-Completed', 'Reamaining-Task'];
  public doughnutChartType = 'doughnut';
  public doughnutData = [40, 60];


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
      })

  }

}
