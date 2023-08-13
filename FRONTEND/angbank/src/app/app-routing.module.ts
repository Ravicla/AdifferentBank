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

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent},
  {path: 'newUser', component: UserFormComponent},
  {path: 'userList', component: UserListComponent},
  {path: 'newActivity', component: ActivityFormComponent},
  {path: 'newCredit', component: CreditFormComponent},
  {path: 'creditList', component: CreditListComponent},
  {path: 'activityList', component: ActivityListComponent},
  {path: 'userCreditList', component: UserCreditListComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
