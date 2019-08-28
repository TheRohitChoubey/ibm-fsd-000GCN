import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDisplayComponent } from './user-display/user-display.component';
import { UserAddComponent } from './user-add/user-add.component';
import { UserEditComponent } from './user-edit/user-edit.component';
import { TopmenuComponent } from './topmenu/topmenu.component';
import { FormsModule } from "@angular/forms";
import { Routes, RouterModule } from "@angular/router";
import { AppRoutingModule } from '../app-routing.module';
import { EditComponent } from './edit/edit.component';


@NgModule({
  declarations: [UserDisplayComponent, UserAddComponent, UserEditComponent, TopmenuComponent, EditComponent],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule
  ],
  exports:[TopmenuComponent]
})
export class UserModule { }
