import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Authentication } from 'src/app/model/authentication';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  authentication:Authentication=new Authentication();

  info: {
    token: string,
    emailId: string,
    role: string,
    message: string
  }

  errorMessage : string;

  constructor(private authenticationService:AuthenticationService, private router:Router) { 

  }

  ngOnInit(): void {
  }

  onSubmit(){
     this.authenticateUser();
  }

  authenticateUser(){
    this.authenticationService.authenticateUser(this.authentication).subscribe(data=>{
      console.log(data);
      this.info = data;
      localStorage.setItem("emailId",this.info.emailId)
      localStorage.setItem("role",this.info.role);
      localStorage.setItem("token",this.info.token);
      //this.goToDashboard();
      if(this.info.role == "Learner"){
        this.router.navigate(['/dashboard']);
      }else if (this.info.role == "Instructor"){
        this.router.navigate(['/instructor-dashboard']);
      }
    },
    error=>{
      console.log(error);
      this.errorMessage=error.error});

  }

  // goToDashboard(){
  //   this.router.navigate(['/instructor-dashboard'])
  // }

}
