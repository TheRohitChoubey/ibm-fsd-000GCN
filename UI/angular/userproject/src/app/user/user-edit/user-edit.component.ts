import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../structure/user';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  constructor(private eUser:UserService,private route:ActivatedRoute,private router:Router) { }
  users: User[];
  ngOnInit() {
    this.users = this.eUser.getUsers();
  }

  delUser(id){
    this.users = this.eUser.delUser(id);
  }

  editUser(id){
    this.router.navigate(['edit'],{ queryParams:{ id: id }});
  }

}
