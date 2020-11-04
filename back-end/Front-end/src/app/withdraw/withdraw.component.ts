import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {
  email: string
  userData: any
  withdrawForm: FormGroup
  constructor(private route: ActivatedRoute, private router: Router) {
    this.email = "";
    this.userData = [];
  }

  ngOnInit() {
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
    this.withdrawForm = new FormGroup({
      amount: new FormControl("")
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

  submit() {
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=false);
    let amount = this.withdrawForm.value.amount;
    let baseUrl = `http://localhost:8092/users/withdraw`;
    fetch(baseUrl, {
      method: "POST",
      headers: {
        "content-Type": "application/json",
        "Accept": 'application/json'
      },
      body: JSON.stringify({ details: this.userData, amount: amount })
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
