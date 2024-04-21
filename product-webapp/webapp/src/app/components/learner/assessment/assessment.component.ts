import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssessmentService } from 'src/app/services/assessment.service';

@Component({
  selector: 'app-assessment',
  templateUrl: './assessment.component.html',
  styleUrls: ['./assessment.component.css']
})
export class AssessmentComponent implements OnInit {
  assessments: any;
  email: String;

  constructor(private assessmentService: AssessmentService, private router: Router) { }

  ngOnInit(): void {
    this.email=localStorage.getItem("emailId");
    this.assessmentService.getAssessmentBasisUser(this.email).subscribe((data)=>{
      this.assessments=data;
      console.log("assessments:", this.assessments);
    })
  }

  createAssignment(batchId:String, assignemtId: String) {
    console.log("assignmetId:", assignemtId);
    console.log("batchId:", batchId);
    this.router.navigate([`/dashboard/createAssignment/${batchId}/${assignemtId}`]);
  }

}
