import { Component, OnInit } from '@angular/core';
import { PaymentscheduleService } from '../paymentschedule.service';
// import {paymentscheduleservice} from 'paymentschedule.service';
@Component({
  selector: 'app-displayschedule',
  templateUrl: './displayschedule.component.html',
  styleUrls: ['./displayschedule.component.css']
})
export class DisplayscheduleComponent implements OnInit {
  // paymentscheduleservice: any;
  

  scheduleList: any=[];
  constructor(private Paymentscheduleservice:PaymentscheduleService) {
    this.getSchedulelist();
   }

  ngOnInit(): void {
  }
  getSchedulelist(){
    this.Paymentscheduleservice.displaySchedule().subscribe(
      (resp)=>{
        console.log(resp)
        this.scheduleList=resp;
      },
      (err)=>{
        console.log(err);
      }
    )
  }

}
