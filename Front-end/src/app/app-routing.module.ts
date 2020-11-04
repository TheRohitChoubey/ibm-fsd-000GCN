import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { DepositeOtherComponent } from './deposite-other/deposite-other.component';
import { HistoryComponent } from './history/history.component';
import { LogoutComponent } from './logout/logout.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [
  {
    path: 'user',
    children: [
      {
        path: 'depositMoney',
        component: DepositComponent
      },
      {
        path: 'depositOtherMoney',
        component: DepositeOtherComponent
      },
      {
        path: 'history',
        component: HistoryComponent
      },
      {
        path: 'logout',
        component: LogoutComponent
      },
      {
        path: 'withdrawMoney',
        component: WithdrawComponent
      },
      {
        path: '**',
        component: UserComponent
      }
    ]
    
  },
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: '**',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
