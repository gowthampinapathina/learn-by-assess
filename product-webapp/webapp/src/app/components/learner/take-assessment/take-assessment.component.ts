import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AssessmentService } from 'src/app/services/assessment.service';

@Component({
  selector: 'app-take-assessment',

  templateUrl: './take-assessment.component.html',

  styleUrls: ['./take-assessment.component.css']
})
export class TakeAssessmentComponent implements OnInit {
  questions: any;
  question: any;
  batchId: String;
  assignmentId: String;
  answer: String
  index=0;
  size=0;
  noQuestions=false;
  answerForm: FormGroup;
  loggedIn: String;
  
  constructor(private assessmentService: AssessmentService, private formBuilder:FormBuilder, private activatedRoute: ActivatedRoute) { 
    this.answerForm=this.formBuilder.group({
      participantMailId: [''],
      answerProvided: ['']
    })
    this.batchId=this.activatedRoute.snapshot.params.batchId;
    this.assignmentId=this.activatedRoute.snapshot.params.assignmentId;
  }

  ngOnInit(): void {
    this.assessmentService.getAssessmentBasisBatchAndAssignment(this.batchId, this.assignmentId).subscribe((data)=> {
      this.questions=data;
      this.size=this.questions.length;
      this.getQuestion();
    });
    this.loggedIn=localStorage.getItem("emailId");
  }

  getQuestion() {
    this.question = this.questions[this.index];
    console.log("question:", this.question);
    if (this.question == undefined) {
      this.noQuestions=true;
    }
  }

  submitAnswer(questionId){
    console.log("answer:",this.answer);
    this.answerForm.get("participantMailId").setValue(this.loggedIn);
    this.answerForm.get("answerProvided").setValue(this.answer);
    this.assessmentService.postAnswer(this.batchId, this.assignmentId, questionId, this.answerForm.value).subscribe((data)=> {
      console.log(data);
    });
    this.index=this.index+1;
    this.answer='';
    this.getQuestion();
  }
}
