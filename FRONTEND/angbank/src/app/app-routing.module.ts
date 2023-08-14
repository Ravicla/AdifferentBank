import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/shared/dashboard/dashboard.component';
import { ActivityFormComponent } from './components/admin/activity-form/activity-form.component';
import { CreditFormComponent } from './components/admin/credit-form/credit-form.component';
import { UserFormComponent } from './components/admin/user-form/user-form.component';
import { CreditListComponent } from './components/admin/credit-list/credit-list.component';
import { UserListComponent } from './components/admin/user-list/user-list.component';
import { ActivityListComponent } from './components/admin/activity-list/activity-list.component';
import { UserCreditListComponent } from './components/admin/user-credit-list/user-credit-list.component';
import { Page404Component } from './components/shared/page404/page404.component';
import { UserViewComponent } from './components/admin/user-view/user-view.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'newUser', component: UserFormComponent},

  {path: 'userList', component: UserListComponent},
  {path: 'userList/:url', component: UserViewComponent},

  {path: 'newActivity', component: ActivityFormComponent},
  {path: 'activityList', component: ActivityListComponent},
  {path: 'newCredit', component: CreditFormComponent},
  {path: 'creditList', component: CreditListComponent},
  {path: 'userCreditList', component: UserCreditListComponent},
  { path: '**', component: Page404Component} 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
