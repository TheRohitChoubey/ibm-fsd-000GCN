import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';
import { Emp } from '../interfaces/Emp';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})



export class EmployeeComponent implements OnInit {

  @Output() _EmpDetails = new EventEmitter(); 
  constructor(private uEmployee:EmployeeServiceService) { }

  emps :Emp[]
  status : any
  active : number
  statusDetails(emps){
    this.active=0;
    emps.forEach((e)=>{
      if(e.stat==true)
        this.active++;
    })
    this.status={
      active : this.active,
      inactive : emps.length - this.active,
      total : emps.length
    }
    
    this._EmpDetails.emit(this.status);
  }
  ngOnInit() {
    this.emps = this.uEmployee.getUsers();
    this.statusDetails(this.emps);
  }

  addEmp(){
    this.emps = this.uEmployee.addUser();
    this.statusDetails(this.emps);
  }

  delEmp(id){
    this.emps = this.uEmployee.delUser(id);
    this.statusDetails(this.emps);
  }

}
