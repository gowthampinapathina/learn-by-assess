import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  // homebody:boolean=true;
  // signup:boolean=false;
  // login:boolean=false;

  constructor() { }

  ngOnInit(): void {
  }

  // homeBody(){
  //   this.homebody=true;
  //   this.signup=false;
  //   this.login=false;
  // }
  // signUp(){
  //   console.log("clicked");
  //   this.signup=true;
  //   this.homebody=false;
  //   this.login=false;
  // }

  // appLogin(){
  //   this.login=true;
  //   this.homebody=false;
  //   this.signup=false;
  // }
}
