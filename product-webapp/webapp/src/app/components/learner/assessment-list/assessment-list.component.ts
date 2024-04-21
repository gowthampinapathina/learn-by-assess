import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentService } from 'src/app/services/assessment.service';

@Component({
  selector: 'app-assessment-list',
  templateUrl: './assessment-list.component.html',
  styleUrls: ['./assessment-list.component.css']
})
export class AssessmentListComponent implements OnInit {

  loggedIn: String;
  assessment: any;
  constructor(private assessmentService: AssessmentService, private router: Router) { }

  ngOnInit(): void {
    this.loggedIn=localStorage.getItem("emailId");
    this.assessmentService.getAssignmentByEmail(this.loggedIn).subscribe((data) => {
      this.assessment=data;
      console.log("data:", this.assessment);
    })
  }

  takeAssignment(batchId, assignmentId) {
    console.log("batchid:", batchId);
    console.log("assignment:", assignmentId);
    this.router.navigate([`/dashboard/attempt/${batchId}/${assignmentId}`]);

  }

}
