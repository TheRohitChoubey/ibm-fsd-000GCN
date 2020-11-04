import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-deposite-other',
  templateUrl: './deposite-other.component.html',
  styleUrls: ['./deposite-other.component.css']
})
export class DepositeOtherComponent implements OnInit {

  email: string
  userData: any
  depositForm: FormGroup
  depositOtherForm: FormGroup
  constructor(private route: ActivatedRoute, private router: Router) {
    this.email = "";
    this.userData = [];
  }

  ngOnInit() {
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
    this.depositForm = new FormGroup({
      amount: new FormControl("")
    })

    this.depositOtherForm = new FormGroup({
      emailOther: new FormControl(""),
      amountOther: new FormControl("")
    })
    this.email = localStorage.getItem("email");
    if (this.email != null) {
      let baseUrl = `http://localhost:8092/login/${this.email}`;
      fetch(baseUrl)
        .then(res => res.json())
        .then(user => {
          this.userData = user.user[0];

          if (user.user.length == 0) {
            alert("No Data Found")
            this.router.navigate(['/user']);
          }
        })
    }
    else {
      this.router.navigate(['/login']);
    }
  }


  submitOther() {
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=false);
    let amount = this.depositOtherForm.value.amountOther;
    let email = this.depositOtherForm.value.emailOther;
    console.log(email);
    let baseUrl = `http://localhost:8092/users/depositOther`;
    fetch(baseUrl, {
      method: "POST",
      headers: {
        "content-Type": "application/json",
        "Accept": 'application/json'
      },
      body: JSON.stringify({ details: this.userData, amount: amount, email: email })
    })
      .then(res => res.json())
      .then(user => {
        let url = `http://localhost:8092/login/${this.email}`;
        fetch(url)
          .then(res => res.json())
          .then(user => {
            this.userData = user.user[0];
          })
      })
      setTimeout(()=>{
        document.getElementById("openModal").click();
        ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
        },7000)
  }


}
