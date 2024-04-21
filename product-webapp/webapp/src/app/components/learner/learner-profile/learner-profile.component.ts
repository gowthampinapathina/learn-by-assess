import { Component, OnInit } from '@angular/core';
import { Learner } from 'src/app/model/learner';
import { LearnerService } from 'src/app/services/learner.service';

@Component({
  selector: 'app-learner-profile',
  templateUrl: './learner-profile.component.html',
  styleUrls: ['./learner-profile.component.css']
})
export class LearnerProfileComponent implements OnInit {

  learner :Learner;
  learnerMail :String = localStorage.getItem("emailId");

  constructor(private learnerService: LearnerService) { }

  ngOnInit(): void {
    this.getLearnerDetails();
  }

  getLearnerDetails(){
    this.learnerService.getLearner(this.learnerMail).subscribe(data=>{
      console.log(data);
      this.learner=data;      
    },
    error => console.log(error)
    )
  }

}
