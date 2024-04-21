import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AssignmentQuestion } from 'src/app/model/Assessment-Service-model/assignmentQuestion.model';
import { AssessmentService } from 'src/app/services/assessment.service';

@Component({
  selector: 'app-assessment-abc',
  templateUrl: './assessment-abc.component.html',
  styleUrls: ['./assessment-abc.component.css']
})
export class AssessmentABCComponent implements OnInit {

  assignmentId: String 
  batchId: String 
  submitted = false;

  questionTypes: string[] = ['MCQ'];
  statusValue: String[] = ['true', 'false'];
  levels: string[] = ['Easy', 'Medium', 'Hard'];
  options: string[] = ['','','',''];

  private assessmentService: AssessmentService;
  private router: Router;

  constructor(assessmentService: AssessmentService, router: Router, private activatedRoute: ActivatedRoute, private formBuilder: FormBuilder) {
    this.assessmentService = assessmentService;
    this.router = router;
    // this.questionForm = this.createFormGroup();
    this.assignmentId=this.activatedRoute.snapshot.params.assignId;
    this.batchId=this.activatedRoute.snapshot.params.batchId;
    this.constructForm();
  }
  message:string="";

  saveQuestion() {
    this.submitted = true;
    // Make sure to create a deep copy of the form-model
    const result: AssignmentQuestion = Object.assign({}, this.praQuestionForm.value);
    // result.optionsStatus = Object.assign({}, result.optionsStatus);

    // Do useful stuff with the gathered data
    console.log("data while saving:",result);

    this.assessmentService.addQuestion(this.batchId, this.assignmentId, result).subscribe(
      data => console.log(data),
      error => console.log(error)
    )

    this.message="Question is Added";
    this.praQuestionForm.reset();

  }

  resetQuestion() {
    // Resets to blank object
    this.praQuestionForm.reset();
  }
  ngOnInit(): void {
  }

  data = {
    optionsStatus: [
      {
        option: '',
        state: ''
      }
    ]
  };

  praQuestionForm: FormGroup;

  constructForm(){
    this.praQuestionForm=this.formBuilder.group({
      questionId: [''],
      questionType: [''],
      questionStem: [''],
      questionLevel: [''],
      questionMark: [''],
      optionsStatus: this.formBuilder.array([]),
      correctAnswer: ['']
    });
    this.setOption();
  }

  get optionFormArr(): FormArray {
    return this.praQuestionForm.get('optionsStatus') as FormArray;
  }

  addNewOption() {
    this.optionFormArr.push(
      this.formBuilder.group({
        option: [''],
        state: ['']
      })
    );
  }

  deleteOption(index) {
    this.optionFormArr.removeAt(index);
  }

  setOption() {
    this.data.optionsStatus.forEach(x => {
      this.optionFormArr.push(
        this.formBuilder.group({
          option: x.option,
          state: x.state
        })
      );
    });
  }

}
