import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Assignment } from 'src/app/model/Assessment-Service-model/assignment.model';
import { AssignmentTemplate } from 'src/app/model/Assessment-Service-model/assignmentTemplate.model';
import { AssessmentService } from 'src/app/services/assessment.service';

@Component({
  selector: 'app-instructors-create-formal-assessment',
  templateUrl: './instructors-create-formal-assessment.component.html',
  styleUrls: ['./instructors-create-formal-assessment.component.css']
})
export class InstructorsCreateFormalAssessmentComponent implements OnInit {
  assignment: Assignment = new Assignment();
  @Input() batchId: String;
  @Input() accessorId: String;
  submitted = false;
   
   private assessmentService: AssessmentService;
   private router: Router;

   statuses = ['pending', 'completed'];
  
  assignmentForm: FormGroup
  
  constructor(assessmentService: AssessmentService, router: Router) {
    this.assessmentService=assessmentService;
    this.router=router;
    this.assignmentForm = this.createFormGroup();
}

  createFormGroup() {
    return new FormGroup({
      assignmentId: new FormControl('',[Validators.required,Validators.minLength(4)]),
      assessorId: new FormControl('',[Validators.required]),
      assignmentTemplate: new FormGroup({
        assessmentName: new FormControl('',[Validators.required,Validators.minLength(10)]),
        assessmentDiscipline: new FormControl('',[Validators.required]),
        assessmentStartTime: new FormControl('',[Validators.required]),
        assessmentEndTime: new FormControl('',[Validators.required]),
        rules: new FormControl(),
        totalScore: new FormControl('',[Validators.required]),
        status: new FormControl('',[Validators.required]),
        assessmentConcept: new FormControl('',[Validators.required,Validators.minLength(10)])
      })
    });
  }

ngOnInit() {
  this.assignmentForm.get("assessorId").setValue(this.accessorId);
}

get assignmentId() {
  return this.assignmentForm.get('assignmentId');
} 

get assessorId() {
  return this.assignmentForm.get('assessorId');
} 

get assessmentName() {
  return this.assignmentForm.get('assignmentTemplate').get('assessmentName');
} 

get assessmentDiscipline() {
  return this.assignmentForm.get('assignmentTemplate').get('assessmentDiscipline');
} 
get totalScore() {
  return this.assignmentForm.get('assignmentTemplate').get('totalScore');
} 

get assessmentEndTime() {
  return this.assignmentForm.get('assignmentTemplate').get('assessmentEndTime');
}  

get status() {
  return this.assignmentForm.get('assignmentTemplate').get('status');
}  

get assessmentConcept() {
  return this.assignmentForm.get('assignmentTemplate').get('assessmentConcept');
}  

get assessmentStartTime() {
  return this.assignmentForm.get('assignmentTemplate').get('assessmentStartTime');
}  

message:string="";

onSubmit() {
  this.submitted=true;
  // Make sure to create a deep copy of the form-model
  const result: Assignment = Object.assign({}, this.assignmentForm.value);
  result.assignmentTemplate = Object.assign({}, result.assignmentTemplate);

  // Do useful stuff with the gathered data
  console.log(result);

  this.assessmentService.createAssessment(this.batchId,result).subscribe(
    data => console.log(data),
    error => console.log(error),
  );
  this.message="submitted successfully";
  this.assignmentForm.reset();
  this.assignment = new Assignment();
}

revert() {
  // Resets to blank object
  this.assignmentForm.reset();

  // Resets to provided model
  this.assignmentForm.reset({ assignmentTemplate: new AssignmentTemplate(),assignmentId:'', assessorId:'' });
}
}