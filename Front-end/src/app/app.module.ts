import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule} from "@angular/forms";
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { DepositeOtherComponent } from './deposite-other/deposite-other.component';
import { HistoryComponent } from './history/history.component';
import { AbsolutePipe } from './absolute.pipe';
import { LogoutComponent } from './logout/logout.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';
import {CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FlexLayoutModule } from "@angular/flex-layout";
import { SignupComponent } from './signup/signup.component';
import { ConfirmEqualValidatorDirective } from './angular-validator.directive';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    DepositComponent,
    WithdrawComponent,
    DepositeOtherComponent,
    HistoryComponent,
    AbsolutePipe,
    LogoutComponent,
    SignupComponent,
    ConfirmEqualValidatorDirective
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    FlexLayoutModule
  ],
  providers: [AngularMaterialModule],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
