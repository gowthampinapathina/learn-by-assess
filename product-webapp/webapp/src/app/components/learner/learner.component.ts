import { Component, OnInit } from '@angular/core';
import { Learner } from 'src/app/model/learner';
import { LearnerService } from 'src/app/services/learner.service';

@Component({
  selector: 'app-learner',
  templateUrl: './learner.component.html',
  styleUrls: ['./learner.component.css']
})
export class LearnerComponent implements OnInit {

  sideBarOpen = true;

  learnerName :String;
  learnerMail: String = localStorage.getItem("emailId");

  constructor(private learnerService:LearnerService) { }

  ngOnInit() {
    this.getLearnerDetails();
  }
  sideBarToggler(){
    this.sideBarOpen = !this.sideBarOpen;
  }

  getLearnerDetails(){
    this.learnerService.getLearner(this.learnerMail).subscribe(data=>{
      console.log(data);
      this.learnerName = data.firstName+" "+data.lastName;
      
    },
    error => console.log(error)
    )
  }
}
