import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateloanComponent } from './createloan/createloan.component';
import { DisplayloanComponent } from './displayloan/displayloan.component';
import { DisplayscheduleComponent } from './displayschedule/displayschedule.component';
import { HomepageComponent } from './homepage/homepage.component';


const routes: Routes = [

  {
    path:'homepage',
    component:HomepageComponent
  },
  {
    path:'createloan',
    component:CreateloanComponent
  },
  {
    path:'displayschedule',
    component:DisplayscheduleComponent
  },
  {
    path:'displayloan',
    component:DisplayloanComponent
  }
  // {
  //   path:'**',
  //   component:CreateloanComponent
  // }
  // {
  //   path:'**',component:HomeComponent
  // },
  // {
  //   path:"createLoan",component:CreateLoanComponent
  // },
  // {
  //   path:"createLoan",component:CreateLoanComponent
  // },
  // {
  //   path:'**',component:CreateLoanComponent,pathMatch:'full'
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
