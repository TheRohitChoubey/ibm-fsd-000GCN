import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/Interfaces/Project';
import { Router } from "@angular/router";
import { FormGroup, FormControl } from '@angular/forms';
import { User } from 'src/app/Interfaces/User';
@Component({
  selector: 'app-view-project',
  templateUrl: './view-project.component.html',
  styleUrls: ['./view-project.component.css']
})
export class ViewProjectComponent implements OnInit {
  projects: Project[]
  freeManager : User[]
  project: any
  uProject: any
  id: Number
  admin: string
  pmanagerEmail:any[] =[]
  projectForm : FormGroup

  constructor(private router: Router) {

    this.project = {
      projectId: 0,
      pname: "",
      plocation: "",
      start_date: "",
      end_date: "",
      pmanagerEmail: []
    };

    this.projectForm = new FormGroup({
      pname: new FormControl(""),
      plocation: new FormControl(""),
      start_date: new FormControl(""),
      end_date: new FormControl(""),
      pmanagerEmail: new FormControl(""),
    })
  }

  ngOnInit() {
    this.admin = localStorage.getItem("admin");
    const url = `http://b4ibm21.iiht.tech:8010`;
    fetch(url + `/projects/getallproject`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(data => {
        console.log(data);
        this.projects = data;
      })
  }

  // call Update Form
  updateForm(id) {

    window.localStorage.setItem("projectId", id);
    console.log(id);
    const url = `http://b4ibm21.iiht.tech:8010`;
    fetch(url + `/findbyid/${id}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => res.json())
      .then(data => {
        this.project.projectId = data.projectId;
        this.projectForm.controls["pname"].setValue(data.pname);
        this.projectForm.controls["plocation"].setValue(data.plocation);
        this.projectForm.controls["start_date"].setValue(data.start_date);
        this.projectForm.controls["end_date"].setValue(data.end_date);
        this.projectForm.controls["pmanagerEmail"].setValue(data.email);
        
        console.log(this.projectForm);

        fetch(`http://b4ibm21.iiht.tech:8001/user/role/manager`, {
          method: "GET",
          headers: {
            "Content-Type": "application/json"
          }
        }).then(response => response.json())
          .then(response => {

            this.freeManager = response;
            console.log(this.freeManager);

            for(let i =0 ; i<this.freeManager.length; i++){
              this.pmanagerEmail.push(this.freeManager[i].email);
            }
            console.log(this.pmanagerEmail);
            this.form();

          })


        this.form();

      })

  }

  // deleted

  delete(id) {
    console.log(id);
    const url = `http://b4ibm21.iiht.tech:8010`;
    fetch(url + `/deleteproject/${id}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => res.json)
      .then(res => {
        if (res[0] == "deleted") {
          alert("Project Deleted");
        }
        document.location.reload();
      })
  }

  // view team
  team(id) {
    console.log(id);
    let teams: any
    fetch(`http://b4ibm21.iiht.tech:8001/findbyprojectid/${id}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(res => res.json())
      .then(data => {
        teams = data;
      })
    document.getElementById("teamtoggle").click();
    window.localStorage.setItem("projectId", id);

  }

  // update project
  update() {

    const url = `http://b4ibm21.iiht.tech:8010`;


    this.uProject = [{
      projectId : this.project.projectId,
      pname: this.projectForm.value.pname,
      plocation: this.projectForm.value.plocation,
      start_date: this.projectForm.value.start_date,
      end_date: this.projectForm.value.end_date,
      pmanagerEmail: this.projectForm.value.pmanagerEmail
    }];

    console.log(this.uProject);
    fetch(url + "/project/updateproject", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(this.uProject)
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
      });
    document.getElementById("updateclose").click();

  }

  // update form generation
  form() {
    document.getElementById("toggle").click();

  }
  buttonclicked() {
    console.log("called bro")
  }
  show() {

  }
}
interface Uproject {
  pname: String,
  plocation: String,
  start_date: String,
  end_date: String,
  pmanagerEmail: String
}