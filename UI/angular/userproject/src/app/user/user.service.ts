import { Injectable } from "@angular/core";
import { User } from "./structure/user";

@Injectable({
  providedIn: "root"
})
export class UserService {
  users: User[];
  ind: number;
  constructor() {
    this.users = [
      {
        id: 1,
        name: "John Abraham",
        age: 39
      },
      {
        id: 2,
        name: "Martin Luther King",
        age: 60
      },
      {
        id: 3,
        name: "Bob The Builder",
        age: 8
      }
    ];
  }

  addUser(user) {
    this.users.push(user);
    return this.users;
  }

  delUser(id) {
    this.ind = -1;
    this.users.forEach((u, i) => {
      if (u.id == id) {
        this.ind = i;
      }
    });
    this.users.splice(this.ind, 1);
    return this.users;
  }

  getUsers() {
    return this.users;
  }

  editUser(id,user) {
    this.ind = -1;
    this.users.forEach((u, i) => {
      if (u.id == id) {
        this.ind = i;
      }
    });
    this.users[this.ind].id=id;
    this.users[this.ind].name=user.name;
    this.users[this.ind].age=user.age;
    return this.users;
  }
}
