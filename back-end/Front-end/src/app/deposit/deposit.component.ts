import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { NgbActiveModal, NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  email: string
  userData: any
  depositForm: FormGroup
  depositOtherForm: FormGroup
  @ViewChild('openModal',undefined) openModal:ElementRef;
  constructor(private route: ActivatedRoute, private router: Router, private modalService: NgbModal) {
    this.email = "";
    this.userData = [];
  }

  ngOnInit() {
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
    this.depositForm = new FormGroup({
      amount: new FormControl(0, Validators.min(0))
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
        })
    }
    else {
      this.router.navigate(['/login']);
    }
  }

  submit() {
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=false);
    let amount = this.depositForm.value.amount;
    console.log(amount, this.email);
    let baseUrl = `http://localhost:8092/users/deposit`;
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


