import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../Interfaces/User';
import { UserService } from '../user.service';
import { Tasks } from '../Interfaces/Tasks';
import { Project } from '../Interfaces/Project';

@Component({
  selector: 'app-managerhome',
  templateUrl: './managerhome.component.html',
  styleUrls: ['./managerhome.component.css']
})
export class ManagerhomeComponent implements OnInit {
  userData: User
  email: string
  manager: string
  tasks: Tasks[]
  project: Project
  completedCount: any
  ongoingCount: any
  stuck: any
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {
    this.userData = {
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

    this.project = {
      projectId: 0,
      pname: "",
      plocation: "",
      start_date: "",
      end_date: "",
      pmanagerEmail: ""
    }

  }


  public doughnutLables = ['Completed', 'OnGoing', 'Stuck'];
  public doughnutChartType = 'doughnut';
  public doughnutData = [, , ,];

  public pieLabels = [];
  public pieData = [, , ,];
  public pieChartType = 'pie';

  ngOnInit() {
    this.manager = localStorage.getItem("manager");
    this.email = localStorage.getItem("email");
    const _baseUrl = `http://b4ibm21.iiht.tech:8001/`;
    fetch(_baseUrl + `/user/${this.email}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
        this.manager = res.username;
        console.log(this.manager);
        this.userData = res;
        localStorage.setItem("manager", this.manager);

        const prourl = `http://b4ibm21.iiht.tech:8010`;
        fetch(prourl + `/findbyemail/${this.userData.email}`, {
          method: "GET",
          headers: {
            "Content-Type": "application/json"
          }
        }).then(pro => pro.json())
          .then(pro => {
            if (pro == null) {
              console.log("No-Project-Found");
            } else {
              this.project = pro;
            }

            const taskurl = `http://b4ibm21.iiht.tech:8021`;
         
            fetch(taskurl + `/getAllTasks/${this.project.projectId}`, {
              method: "GET",
              headers: {
                "Content-Type": "application/json"
              }
            }).then(tas => tas.json())
              .then(tas => {

                this.tasks = tas;
                console.log(this.tasks);
                this.firstinit();

              })
          })

      })
  }

  firstinit() {

    // doughnut chart
    this.completedCount = 0;
    this.ongoingCount = 0;
    this.stuck = 0;
    for (let i = 0; i < this.tasks.length; i++) {

      if (this.tasks[i].status == 'completed') {
        this.completedCount++;
      } else if (this.tasks[i].status == 'ongoing') {
        this.ongoingCount++;
      } else if (this.tasks[i].status == 'stuck') {
        this.stuck++;
      }


    }

    this.doughnutData = [this.completedCount, this.ongoingCount, this.stuck];

   


  }
  update() {

    const _baseUrl = `http://b4ibm21.iiht.tech:8001/`;

    fetch(_baseUrl + `/update/${this.userData.email}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(this.userData)
    }).then(res => res.json())
      .then(data => {

        alert(`--` + data);

      })
    document.getElementById("close").click();
  }
}
