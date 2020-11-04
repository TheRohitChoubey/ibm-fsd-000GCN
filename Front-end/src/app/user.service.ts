import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userData : User
  constructor() { }

  getUserByEmail(callback,email:string){
    let baseUrl = `http://localhost:8090/login/${email}`;
    fetch(baseUrl)
    .then(res=>res.json())
    .then(user=>{
        callback(user.user)
    })
    
  }
}
