import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/Interfaces/Project';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-adminupdateproject',
  templateUrl: './adminupdateproject.component.html',
  styleUrls: ['./adminupdateproject.component.css']
})
export class AdminupdateprojectComponent implements OnInit {
  projectId:number
  project:Project
  newProjectForm:FormGroup
  constructor() {
    this.newProjectForm = new FormGroup({
      pname: new FormControl(this.project.pname),
      plocation: new FormControl(this.project.plocation),
      start_date: new FormControl(this.project.start_date),
      end_date: new FormControl(this.project.end_date),
      pmanagerEmail: new FormControl(this.project.pmanagerEmail)
    })
   }

  ngOnInit() {
    this.projectId = parseInt(localStorage.getItem("projectId"));
    console.log(this.projectId);
    localStorage.removeItem("projectId");
    const url = `http://b4ibm21.iiht.tech:8010`;
    fetch(url+`/findbyid?id=$${this.projectId}`,{
      method:"GET",
      headers:{
        "Content-Type":"application/json"
      }
    }).then(res=>res.json())
    .then(data=>{
      console.log(data);
      this.project=data;
    })
  }

  update(){

    this.project.plocation=this.newProjectForm.value.plocation;
    this.project.start_date= this.newProjectForm.value.start_date;
    this.project.end_date=this.newProjectForm.value.end_date;
    console.log(this.project);

  }

}
