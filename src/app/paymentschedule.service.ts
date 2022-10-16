import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'platform'
})
export class PaymentscheduleService {

  constructor(private http:HttpClient) { }
  API='http://localhost:8080';
  public displaySchedule(){
    return this.http.get(this.API+'/schedule');
  }
  public displayLoan(){
    return this.http.get(this.API + '/customerloans')
  }
}
