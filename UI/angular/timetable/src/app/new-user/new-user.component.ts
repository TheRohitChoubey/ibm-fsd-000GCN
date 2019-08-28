import { Component, OnInit } from "@angular/core";
import {
  FormBuilder,
  FormGroup,
  FormArray,
  FormControl,
  ValidatorFn,
  FormControlName
} from "@angular/forms";

@Component({
  selector: "app-new-user",
  templateUrl: "./new-user.component.html",
  styleUrls: ["./new-user.component.css"]
})
export class NewUserComponent implements OnInit {
  newUserForm: FormGroup;

  constructor() {
    this.newUserForm = new FormGroup({
      subjects: new FormGroup({
        maths: new FormControl("Maths"),
        com: new FormControl("Computer"),
        eng: new FormControl("English")
      }),
      name: new FormControl("")
    });
  }

  ngOnInit() {}

  submit() {
    let subjects = this.newUserForm.value.subjects;
    let name = this.newUserForm.value.name;
    console.log("Subjects = ",subjects);
    let _user = [];
    if (subjects.maths != false) {
      _user = [
        {
          subject: "maths",
          name: name
        }
      ];
    }
    if (subjects.eng != false) {
      _user.push({
        subject: "english",
        name: name
      });
    }

    if (subjects.com != false) {
      _user.push({
        subject: "computer",
        name: name
      });
    }
    console.log("Users = ",_user);
    
    const _baseUrl = `http://localhost:1234/users`;
    // make call to fetch api
    // interact with nodejs server
    fetch(_baseUrl + "/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        user: _user
      })
    })
      .then(res => res.json())
      .then(res => {
        console.log(res);
      });
  
  }
}
