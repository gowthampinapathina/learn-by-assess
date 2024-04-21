import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Learner } from '../model/learner';


@Injectable({
  providedIn: 'root'
})
export class LearnerService {

  constructor(private http:HttpClient) {}

  createLearner(learner : Learner): Observable<Object>{
    return this.http.post<Learner>("/api/v1/learner/learner",learner)
  }

  getLearner(learnerMail:String): Observable<Learner>{
    return this.http.get<Learner>(`/api/v1/learner/getLearner/`+learnerMail)
  }
}
