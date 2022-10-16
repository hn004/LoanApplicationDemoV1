import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PaymentscheduleService } from '../paymentschedule.service';

@Component({
  selector: 'app-displayloan',
  templateUrl: './displayloan.component.html',
  styleUrls: ['./displayloan.component.css']
})
export class DisplayloanComponent implements OnInit {

  constructor(private paymentschedule:PaymentscheduleService) { 
    this.getLones();
  }

  ngOnInit(): void {
  }
  custLone:any=[]; 
  getLones(){
    this.paymentschedule.displayLoan().subscribe(
      (resp)=>{
        console.log(resp);
        this.custLone=resp;
      },
      (err)=>{
        console.log(err);
      }
    )
  }
}
