import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreateloanService {
  API='http://localhost:8080'
  constructor(private http:HttpClient) { }
  public registerLoan(loanEntity: any){
    return this.http.post(this.API + '/createlone',loanEntity);
  }
}
