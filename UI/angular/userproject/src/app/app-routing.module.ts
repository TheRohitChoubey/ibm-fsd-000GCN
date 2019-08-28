import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { UserDisplayComponent } from './user/user-display/user-display.component';
import { UserAddComponent } from './user/user-add/user-add.component';
import { UserEditComponent } from './user/user-edit/user-edit.component';
import { EditComponent } from './user/edit/edit.component';

const routes: Routes = [
  {
    path: "home",
    component : UserDisplayComponent
  },
  {
    path: 'adduser',
    component : UserAddComponent
  },
  {
    path: 'edituser',
    component : UserEditComponent
  },
  {
    path : 'edit',
    component : EditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
