import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { ReactiveFormsModule,FormsModule } from "@angular/forms";
import { SidebarModule } from "ng-sidebar";
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { ManagerhomeComponent } from './managerhome/managerhome.component';
import { ProjectserviceComponent } from './projectservice/projectservice.component';
import { AddProjectComponent } from './projectservice/add-project/add-project.component';
import { ViewProjectComponent } from './projectservice/view-project/view-project.component';
import { TaskServiceComponent } from './task-service/task-service.component';
import { TeamServiceComponent } from './team-service/team-service.component';
import { AddTaskComponent } from './task-service/add-task/add-task.component';
import { ViewTaskComponent } from './task-service/view-task/view-task.component';
import { AddTeamComponent } from './team-service/add-team/add-team.component';
import { ViewTeamComponent } from './team-service/view-team/view-team.component';
import { UserServiceComponent } from './user-service/user-service.component';
import { AddComponent } from './user-service/add/add.component';
import { ViewComponent } from './user-service/view/view.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';
import { ChartsModule } from "ng2-charts";
import { UsercomponentsComponent } from './usercomponents/usercomponents.component';
import { ViewTeamsComponent } from './usercomponents/view-teams/view-teams.component';
import { ViewTasksComponent } from './usercomponents/view-tasks/view-tasks.component';
import { UpdateTasksComponent } from './usercomponents/update-tasks/update-tasks.component';
import { ViewProjectdetailsComponent } from './usercomponents/view-projectdetails/view-projectdetails.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { LoginComponent } from './login/login.component';





@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignupComponent,
    AdminhomeComponent,
    UserhomeComponent,
    ManagerhomeComponent,
    ProjectserviceComponent,
    AddProjectComponent,
    ViewProjectComponent,
    TaskServiceComponent,
    TeamServiceComponent,
    AddTaskComponent,
    ViewTaskComponent,
    AddTeamComponent,
    ViewTeamComponent,
    UserServiceComponent,
    AddComponent,
    ViewComponent,
    UpdateprofileComponent,
    UsercomponentsComponent,
    ViewTeamsComponent,
    ViewTasksComponent,
    UpdateTasksComponent,
    ViewProjectdetailsComponent,
    LoginComponent

   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    SidebarModule,
    ChartsModule,
    CalendarModule,
 
 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
