import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AssessmentGeneration } from '../model/Assessment-Service-model/assessment-generation.model';
import { Assignment } from '../model/Assessment-Service-model/assignment.model';
import { AssignmentQuestion } from '../model/Assessment-Service-model/assignmentQuestion.model';
@Injectable({
  providedIn: 'root'
})
export class AssessmentService {

  baseUrl='/api/v1/assessment';

  constructor(private http: HttpClient) {}

  createAssessment(batchId: String, assignment:Assignment): Observable<AssessmentGeneration> {
  return this.http.post<AssessmentGeneration>(`${this.baseUrl}/add-assignment/${batchId}`,assignment);
  }

  addQuestion(batchId:String, assignmentId: String, question:AssignmentQuestion): Observable<Assignment> {
    return this.http.post<Assignment>(`${this.baseUrl}/addQuestions/${batchId}/${assignmentId}`, question)
  }

  getAssessmentBasisUser(email: String){
    return this.http.get<any>(`${this.baseUrl}/getAssessment/${email}`);
  }

  getAssessmentBasisBatchAndAssignment(batchId: String, assignmentId: String){
    return this.http.get<any>(`${this.baseUrl}/assignment/${batchId}/${assignmentId}`);
  }

  postAnswer(batchId: String, assignmentId:String, questionId:String, answer:any){
    return this.http.post<any>(`${this.baseUrl}/learnerAnswer/${batchId}/${assignmentId}/${questionId}`, answer);
  }

  getAssignmentByEmail(email:String) {
    return this.http.get<any>(`${this.baseUrl}/getAssignment/${email}`);
  }
}
