import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  email: string
  userData: any
  constructor(private route: ActivatedRoute, private router: Router) {
    this.email = "";
    this.userData = [];
  }
  
  ngOnInit() {
    ((<HTMLInputElement>document.getElementById("spinner")).hidden=false);
    this.email = localStorage.getItem("email");
    if (this.email != null) {
      
      let baseUrl = `http://localhost:8092/login/${this.email}`;
      fetch(baseUrl)
        .then(res => res.json())
        .then(user => {
          this.userData = user.user[0];
          ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
        })
        
    }
    else{
      ((<HTMLInputElement>document.getElementById("spinner")).hidden=true);
      this.router.navigate(['/login']);
    }
    
  }

}

