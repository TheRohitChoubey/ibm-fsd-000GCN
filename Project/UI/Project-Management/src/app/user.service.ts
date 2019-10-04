import { Injectable } from '@angular/core';
import { User } from './Interfaces/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users:User
  constructor() { }

  getUserByEmail(callback,email:string){
    const _baseUrl = `http://b4ibm21.iiht.tech:8001/user/${email}`;
    fetch(_baseUrl)
    .then(res=>res.json())
    .then(users=>{
      callback(users);
    }).catch(err=>console.error(err));
  }

}
