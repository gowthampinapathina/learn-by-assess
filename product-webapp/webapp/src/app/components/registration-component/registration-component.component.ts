import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Learner } from 'src/app/model/learner';
import { LearnerService } from 'src/app/services/learner.service';


@Component({
  selector: 'app-registration-component',
  templateUrl: './registration-component.component.html',
  styleUrls: ['./registration-component.component.css']
})
export class RegistrationComponentComponent implements OnInit {

  learner : Learner = new Learner();

  constructor(private learnerService:LearnerService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.saveLearner();
  }

  saveLearner(){
    this.learner.age=20;
    this.learnerService.createLearner(this.learner).subscribe(data =>{
      console.log(data);
      this.goToLogin();
    },
    error => console.log(error));
  }

  goToLogin(){
    this.router.navigate(['/login']);
  }
}
