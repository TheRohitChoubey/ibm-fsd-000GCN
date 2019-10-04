import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  newLoginForm: FormGroup
  constructor(private route: ActivatedRoute, private router: Router) {
    this.newLoginForm = new FormGroup({
      email: new FormControl(""),
      password: new FormControl("")
    })
  }

  ngOnInit() {
  }

  submit() {
    let email = this.newLoginForm.value.email;
    let password = this.newLoginForm.value.password;

    let loginDetails = [];
    loginDetails.push({
      email: email, password: password
    });
    const _baseUrl = `http://b4ibm21.iiht.tech:8001`;

    fetch(_baseUrl + `/user/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(loginDetails)
    })
      .then(res => res.json())
      .then(res => {
        let uType = res.userType;
        let email = res.email;
        if (uType == "manager") {
          this.router.navigate(['/managerhome'],{ queryParams: {email: email} });
        } else if (uType == "user") {
          this.router.navigate(['/userhome'], { queryParams: {email: email}});
        } else if (uType == "admin") {
          this.router.navigate(['/adminhome'],{ queryParams: {email: email }});
        }
      })

  }

}
