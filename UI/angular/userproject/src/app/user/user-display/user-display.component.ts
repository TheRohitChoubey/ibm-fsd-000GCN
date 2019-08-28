import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../structure/user';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-display',
  templateUrl: './user-display.component.html',
  styleUrls: ['./user-display.component.css']
})
export class UserDisplayComponent implements OnInit {
  users: User[];
  @Output() _UserDetails = new EventEmitter(); 
  constructor(private eUser:UserService) { }

  ngOnInit() {
    this.users = this.eUser.getUsers();
  }

}
