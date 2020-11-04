import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  _baseUrl: any
  userData: any
  email: string
  registerForm: FormGroup
  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      email: new FormControl("",Validators.compose([
        Validators.required,Validators.email
      ])),
      password: new FormControl("",Validators.compose([
        Validators.required,Validators.minLength(6),Validators.maxLength(30)
      ])),
      confirmPassword: new FormControl("",Validators.compose([
        Validators.required,Validators.minLength(6),Validators.maxLength(30)
      ])),
      name: new FormControl("",Validators.compose([
        Validators.required,Validators.minLength(3),Validators.maxLength(30)
      ])),
      amount: new FormControl(0,Validators.compose([
        Validators.required,Validators.min(0),Validators.max(50000), Validators.pattern(/^\d+$/)
      ]))
    })
    this.email = localStorage.getItem("email");
    if (this.email != null) {
      this.router.navigate(['/user']);
    }
  }

  submit() {
    let newEmail = this.registerForm.value.email;
    let password = this.registerForm.value.password;
    let name = this.registerForm.value.name;
    let amount = this.registerForm.value.amount;

    let baseUrl = `http://localhost:8092/signup`;
    fetch(baseUrl, {
      method: "POST",
      headers: {
        "content-Type": "application/json",
        "Accept": 'application/json'
      },
      body: JSON.stringify({ name: name, email: newEmail, password: password, amount: amount })
    })
      .then(res => res.json())
      .then(user => {
        console.log(user);
        if (user.user === "") {
          alert("Registered\n Click ok to login");
          localStorage.setItem("email", newEmail);
          this.router.navigate(['/user']);
        }
        else {
          alert("User already exist with this email");
        }
      })

  }

  emailDataValidator(control: FormControl) {
    let email = control.value;
    console.log(email);
  }

}
