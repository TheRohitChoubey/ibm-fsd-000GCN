import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { UsersComponent } from './users/users.component';
import { EditComponent } from './edit/edit.component';
import { QueryparamComponent } from './queryparam/queryparam.component';
import { AddComponent } from './project/add/add.component';
import { ListComponent } from './project/list/list.component';

const routes: Routes = [
  {
    path: "home",
    component : HomeComponent 
  },
  {
    path: 'aboutus',
    component : AboutusComponent
  },
  {
    path: 'users/:id',
    component: UsersComponent
  },
  {
    path : 'edit',
    redirectTo: 'params'
  },
  {
    path: 'params',
    component: QueryparamComponent
  },
  {
    path: 'projects',
    children:[
      {
        path: 'list',
        children:[
          {
            path: 'sub',
            component: AddComponent
          },
          {
            path: '',
            component: ListComponent
          }
        ]
      },
      {
        path: 'add',
        component: AddComponent
      },
      {
        path: 'edit',
        component: EditComponent
      },
      {
        path: '',
        component: ListComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
