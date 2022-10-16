import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { CreateloanService } from '../createloan.service';

@Component({
  selector: 'app-createloan',
  templateUrl: './createloan.component.html',
  styleUrls: ['./createloan.component.css']
})
// export class LoanEntity {
//   constructor(
   
//     public customerId: number,
//     public loanAmount: number,
//     public tradeDate: Date,
//     public loanStartDate: Date,
//     public maturityDate: Date,
//     public paymentFrequency: number,
//     public interestRate: number,
//     public tenure: number,
//     public principle: string
//   ) {}

  
// }
export class CreateloanComponent implements OnInit {
 
  // loanEntity!: LoanEntity;
  currentDate = new Date();
  customerId: number = 0;
  loanAmount:Number=0;
  interestRate: Number=0;
  tenure:Number=0;
  paymentFrequency:number=0;
  PaymentTerm!: String;
  loanStartDate:any;


  form = new FormGroup({
    
  })
  constructor(private createloan:CreateloanService) { }
  register(registerForm: NgForm){
    this.createloan.registerLoan(registerForm.value).subscribe(
      (resp)=>{
        console.log(resp)
        registerForm.reset();
        // this.getLones();
      },
      (err)=>{
        console.log(err)
      }
    );
  }
  
  saveLoan(){

  }
  ngOnInit(): void {
  }

}
