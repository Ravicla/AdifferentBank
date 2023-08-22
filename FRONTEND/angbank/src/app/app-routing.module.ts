import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/shared/dashboard/dashboard.component';
import { ActivityFormComponent } from './components/admin/activity-form/activity-form.component';
import { CreditFormComponent } from './components/admin/credit-form/credit-form.component';
import { UserFormComponent } from './components/admin/user-form/user-form.component';
import { CreditListComponent } from './components/admin/credit-list/credit-list.component';
import { UserListComponent } from './components/admin/user-list/user-list.component';
import { ActivityListComponent } from './components/admin/activity-list/activity-list.component';
import { Page404Component } from './components/shared/page404/page404.component';
import { UserViewComponent } from './components/admin/user-view/user-view.component';
import { ActivitySettingComponent } from './components/admin/setting/activity-setting/activity-setting.component';
import { RolSettingComponent } from './components/admin/setting/rol-setting/rol-setting.component';
import { CaracteristicasComponent } from './components/admin/user-view/caracteristicas/caracteristicas.component';
import { OpinionesComponent } from './components/admin/user-view/opiniones/opiniones.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'dashboard' },
  { path: 'dashboard', component: DashboardComponent },

  { path: 'newUser', component: UserFormComponent },
  { path: 'updateUser/:iduser', component: UserFormComponent },

  { path: 'users', component: UserListComponent },
  { path: 'user/:iduser', component: UserViewComponent, children: [
    { path: 'caracteristicas', component: CaracteristicasComponent },
    { path: 'opiniones', component: OpinionesComponent }
  ] },
  
  { path: 'newActivity', component: ActivityFormComponent },
  { path: 'activityList', component: ActivityListComponent },
  
  { path: 'newCredit', component: CreditFormComponent },
  { path: 'creditList', component: CreditListComponent },

  { path: 'activitySetting', component: ActivitySettingComponent },
  { path: 'rolSetting', component: RolSettingComponent },



  { path: '**', component: Page404Component }, 

  

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
