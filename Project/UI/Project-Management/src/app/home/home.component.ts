import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from '../Interfaces/User';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  newLoginForm: FormGroup

  constructor(private route: ActivatedRoute, private router: Router) {
    this.newLoginForm = new FormGroup({
      email: new FormControl("",[Validators.required,Validators.email]),
      password: new FormControl("",[Validators.required])
    })
  }
  ngOnInit() {
   window.localStorage.clear();
  }

  // navtosearch(){
  //  this.router.navigate(['/flightsearch']);
  // }
  submit() {

    
    let email = this.newLoginForm.value.email;
    let password = this.newLoginForm.value.password;
   

    localStorage.setItem("email",email);
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
        
        console.log(res);
        if(res.message=="Email or password is wrong"){
          alert("Invalid Credential Try Again");
          document.getElementById("errEmail").style.display="none";
          document.getElementById("errPass").style.display="none";

        }else{
        let uType = res.userType;
        let email = res.email;

        if (uType == "manager") {
          this.router.navigate(['/managerhome'],{ queryParams: {email: email} });
        } else if (uType == "user") {
          this.router.navigate(['/userhome'], { queryParams: {email: email}});
        } else if (uType == "admin") {
          this.router.navigate(['/adminhome'],{ queryParams: {email: email }});
        }
        document.getElementById("close").click();
      }
      })
    }

  

}
