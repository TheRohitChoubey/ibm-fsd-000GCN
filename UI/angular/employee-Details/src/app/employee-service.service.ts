import { Injectable } from '@angular/core';
import { Emp } from './interfaces/Emp';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
  users:Emp[]
  ind : number
  constructor() { }

  addUser(){

    this.users.push({
      id: 4,
      name: 'Rohit',
      age: 23,
      stat: true
    });
    return this.users;
  }

  delUser(id){
    this.ind = -1;
    this.users.forEach((u,i)=> {
        if(u.id==id){
          this.ind=i;
        }
    });
    this.users.splice(this.ind,1);
    return this.users;
  }

  getUsers(){
    return this.users =[
      {
        id: 1,
        name: 'John',
        age: 22,
        stat: true
      },
      {
        id: 2,
        name: 'Martin',
        age: 23,
        stat: true
      },
      {
        id: 3,
        name: 'Bob',
        age: 24,
        stat: false
      }
    ]
  }
}
