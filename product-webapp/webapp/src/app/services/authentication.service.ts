import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Authentication } from '../model/authentication';

@Injectable({providedIn: 'root'})
export class AuthenticationService {

  constructor(private http:HttpClient) {}

  authenticateUser(authentication:Authentication):Observable<any>{
    
    return this.http.post<Authentication>("/api/v1/auth/login/user",authentication);

  }

}
