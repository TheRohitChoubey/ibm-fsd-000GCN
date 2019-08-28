import { Component, OnInit } from "@angular/core";
import { UserService } from "../user.service";
import { User } from "../structure/user";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-edit",
  templateUrl: "./edit.component.html",
  styleUrls: ["./edit.component.css"]
})
export class EditComponent implements OnInit {
  constructor(
    private eUser: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  users: User[];
  user: User;
  id: number=this.route.snapshot.queryParams.id;
  ind: number;
  ngOnInit() {
    this.users = this.eUser.getUsers();
    this.ind = -1;
    this.users.forEach((u, i) => {
      if (u.id == this.id) {
        this.ind = i;
      }
    });
    this.user = this.users[this.ind];
  }

  editData() {
    this.users = this.eUser.editUser(this.id, this.user);
  }
}
