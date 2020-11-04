import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  _baseUrl:any
  userData: any
email : string
 emailForm:FormGroup
  constructor(private userService: UserService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.emailForm = new FormGroup({
      email: new FormControl("",Validators.compose([
        Validators.required,Validators.email
      ])),
      password : new FormControl("",Validators.compose([
        Validators.required
      ])),
  })
  this.email = localStorage.getItem("email");
  if(this.email != null){
    this.router.navigate(['/user']);
  }
}

  submit() {
    let email = this.emailForm.value.email;
    console.log(email);
    let baseUrl = `http://localhost:8092/login/${email}`;
    fetch(baseUrl)
    .then(res=>res.json())
    .then(user=>{
      this.userData = user.user;
      
      if(this.userData.length == 0){
        alert("No Data Found")
        this.router.navigate(['/signup']);
      }
      else{
        console.log(this.userData[0]);
        localStorage.setItem("email", this.userData[0].email);
        this.router.navigate(['/user']);
      }
    })
  }


}
