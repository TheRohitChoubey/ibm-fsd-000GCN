import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';

import { UserhomeComponent } from './userhome/userhome.component';
import { ManagerhomeComponent } from './managerhome/managerhome.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AddProjectComponent } from './projectservice/add-project/add-project.component';
import { ViewProjectComponent } from './projectservice/view-project/view-project.component';
import { AddTaskComponent } from './task-service/add-task/add-task.component';
import { ViewTaskComponent } from './task-service/view-task/view-task.component';
import { AddTeamComponent } from './team-service/add-team/add-team.component';
import { ViewTeamComponent } from './team-service/view-team/view-team.component';
import { AddComponent } from './user-service/add/add.component';
import { ViewComponent } from './user-service/view/view.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';
import { UpdateTasksComponent } from './usercomponents/update-tasks/update-tasks.component';
import { ViewTasksComponent } from './usercomponents/view-tasks/view-tasks.component';
import { ViewProjectdetailsComponent } from './usercomponents/view-projectdetails/view-projectdetails.component';
import { ViewTeamsComponent } from './usercomponents/view-teams/view-teams.component';
import { LoginComponent } from './login/login.component';





const routes: Routes = [
  {
    path: 'home',
    component:HomeComponent
  },
  {
    path: 'adminhome',
    component: AdminhomeComponent,
  },
  {
    path: 'updateprofile',
    component: UpdateprofileComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'userhome',
    component: UserhomeComponent
  },
  {
    path: 'managerhome',
    component: ManagerhomeComponent
  }, 
  {
    path: 'projectService',
    children: [
      {
        path: 'add',
        component: AddProjectComponent
      },
      {
        path: 'view',
        component: ViewProjectComponent
      }
    ]
  },
  {
    path: 'taskService',
    children: [
      {
        path: 'add',
        component: AddTaskComponent
      },
      {
        path: 'view',
        component: ViewTaskComponent
      }
    ]
  },
  {
    path: 'userService',
    children: [
      {
        path: 'add',
        component: AddComponent
      },
      {
        path: 'view',
        component: ViewComponent
      }
    ]
  },
  {
    path: 'usercomponents',
      children : [
        {
        path: 'updatetask',
        component: UpdateTasksComponent
      },
      {
        path: 'viewtasklist',
        component: ViewTasksComponent
      },
      {
        path: 'viewprojectdetails',
        component: ViewProjectdetailsComponent
      },
      {
        path: 'viewteamslist',
        component: ViewTeamsComponent
      }
    ]
  },
  {
    path: 'teamService',
    children: [
      {
        path: 'add',
        component: AddTeamComponent
      },
      {
        path: 'view',
        component: ViewTeamComponent
      }
    ]
  },
  {
    path: '',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
