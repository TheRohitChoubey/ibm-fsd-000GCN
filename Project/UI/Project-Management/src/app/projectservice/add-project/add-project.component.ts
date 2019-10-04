import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Interfaces/User';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.css']
})
export class AddProjectComponent implements OnInit {
  users: User[]
  cities : any[]
  role: string
  uNames: userName[]
  newProjectForm: FormGroup
  admin:string
  constructor(private router:Router) {
    
    this.cities = [{city : "Banglore"},{city : "Chennai"},{city : "Gurgaon"},{city : "Hyderabad"},{city : "Kolkata"},
    {city : "Mumbai"},{city : "Pune"}];

    this.role = "manager"
    this.newProjectForm = new FormGroup({
      pname: new FormControl("",[Validators.required]),
      plocation: new FormControl("",[Validators.required]),
      start_date: new FormControl("",[Validators.required]),
      end_date: new FormControl("",[Validators.required]),
      pmanagerEmail: new FormControl("")
    })
  }

  ngOnInit() {
    this.admin=localStorage.getItem("admin");
    const _baseUrl = `http://b4ibm21.iiht.tech:8001/`;
    fetch(_baseUrl + `/user/role/${this.role}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then(res => res.json())
      .then(res => {
        this.users = res;
        this.ints()
      })
  }

  ints() {
    this.uNames = [];
    console.log(this.users);
    for (let i = 0; i < this.users.length; i++) {
      let uDetails = {
        email : this.users[i].email,
         name : this.users[i].username
        }
      this.uNames[i] =(uDetails);
    }
  }

  submit() {
    let projectName = this.newProjectForm.value.pname;
    let projectLocation = this.newProjectForm.value.plocation.city;
    let startDate = this.newProjectForm.value.start_date;
    let endDate = this.newProjectForm.value.end_date;
    let pManagerEmail = this.newProjectForm.value.pmanagerEmail.email;
    console.log(pManagerEmail);

    let projectDetails = [];
    projectDetails.push({pname :projectName, plocation : projectLocation, 
        start_date : startDate, end_date : endDate, pmanagerEmail : pManagerEmail
    });
    const _baseUrl = `http://b4ibm21.iiht.tech:8010`;

    fetch(_baseUrl + "/projects", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(projectDetails)
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
        alert("Project-Added Successfully !!");
            this.router.navigate(['projectService/view']);
      });
  }
}

interface userName{
  email : string
  name : string
}
