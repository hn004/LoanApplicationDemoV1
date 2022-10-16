import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { CreateloanComponent } from './createloan/createloan.component';
import { DisplayscheduleComponent } from './displayschedule/displayschedule.component';
import { DisplayloanComponent } from './displayloan/displayloan.component';
import { HttpClientModule } from '@angular/common/http';
import { PaymentscheduleService } from './paymentschedule.service';
import { FormsModule }   from '@angular/forms';
import { FrontpageComponent } from './frontpage/frontpage.component';
@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    CreateloanComponent,
    DisplayscheduleComponent,
    DisplayloanComponent,
    FrontpageComponent,
 ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PaymentscheduleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
