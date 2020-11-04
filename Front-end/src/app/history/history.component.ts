import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  email: string
  depositForm: FormGroup
  depositOtherForm: FormGroup
  userData: any

  ELEMENT_DATA: PeriodicElement[] = [];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  displayedColumns: string[] = ['date','to','from','amount','transactiontype'];


  constructor(private route: ActivatedRoute, private router: Router) {
    this.email = "";
    this.userData = [];
  }

  ngOnInit() {
    this.depositForm = new FormGroup({
      amount: new FormControl("")
    })

    this.depositOtherForm = new FormGroup({
      emailOther: new FormControl(""),
      amountOther: new FormControl("")
    })
    this.email = localStorage.getItem("email");
    if (this.email != null) {
      let url = `http://localhost:8092/users/history/${this.email}`;
      fetch(url)
        .then(res => res.json())
        .then(history => {
          this.ELEMENT_DATA= history.history;
          this.ELEMENT_DATA.forEach(function (element) {
            element.type = "false";
          });

          let i=0;
          for(i=0; i<this.ELEMENT_DATA.length; i++){
            if(this.ELEMENT_DATA[i].to ==this.email&&this.ELEMENT_DATA[i].from==this.email){
              if(this.ELEMENT_DATA[i].amount>0){
                this.ELEMENT_DATA[i].type= "Self-Credited";
              }
              else{
                this.ELEMENT_DATA[i].type= "Self-Debited";
              }
            }
            else if((this.ELEMENT_DATA[i].to === this.email)&&(this.ELEMENT_DATA[i].from != this.email)){
              this.ELEMENT_DATA[i].type= "Credited";
            }
            else if((this.ELEMENT_DATA[i].to != this.email)&&(this.ELEMENT_DATA[i].from === this.email)){
              this.ELEMENT_DATA[i].type= "Debited";
            }
          }
          this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
          let url = `http://localhost:8092/login/${this.email}`;
          fetch(url)
            .then(res => res.json())
            .then(user => {
              this.userData = user.user[0];
            })
        })
    }
    else {
      this.router.navigate(['/login']);
    }
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
export interface PeriodicElement {
  date: string;
  to: string;
  from: string;
  amount: number;
  type: string;
}