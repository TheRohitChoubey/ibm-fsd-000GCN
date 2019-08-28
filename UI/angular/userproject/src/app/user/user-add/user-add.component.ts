import { Component, OnInit, Output } from '@angular/core';
import { User } from '../structure/user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  user: User[];
  constructor(private eUser:UserService) { }
  
  ngOnInit() {
  }

  addUser(_data){
    this.user = this.eUser.addUser(_data);
    return this.user;
  }
}
