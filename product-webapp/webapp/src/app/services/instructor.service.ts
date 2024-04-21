import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Batch } from '../model/batch';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {

  constructor(private http:HttpClient) { }

  getBatchList(instructorMail:String):Observable<Batch[]>{
    return this.http.get<Batch[]>(`/api/v1/instructor/`+instructorMail);
  }
}
