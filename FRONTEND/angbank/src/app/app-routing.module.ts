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
import { CaracteristicasComponent } from './components/admin/user-view/caracteristicas/caracteristicas.component';
import { OpinionesComponent } from './components/admin/user-view/opiniones/opiniones.component';
import { TypeActivityFormComponent } from './components/admin/setting/typeActivity/type-activity-form/type-activity-form.component';
import { TypeActivityListComponent } from './components/admin/setting/typeActivity/type-activity-list/type-activity-list.component';
import { RolFormComponent } from './components/admin/setting/rol/rol-form/rol-form.component';
import { RolListComponent } from './components/admin/setting/rol/rol-list/rol-list.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'dashboard' },
  { path: 'dashboard', component: DashboardComponent },

  { path: 'newUser', component: UserFormComponent },
  { path: 'updateUser/:userId', component: UserFormComponent },
  { path: 'users', component: UserListComponent },
  
  { path: 'user/:userId', component: UserViewComponent, children: [
    { path: 'caracteristicas', component: CaracteristicasComponent },
    { path: 'opiniones', component: OpinionesComponent }
  ] },
  
  { path: 'newActivity', component: ActivityFormComponent },
  { path: 'activityList', component: ActivityListComponent },
  
  { path: 'newCredit', component: CreditFormComponent },
  { path: 'creditList', component: CreditListComponent },

  { path: 'typeActivityForm', component: TypeActivityFormComponent },
  { path: 'updateTypeActivity/:typeActivityId', component: TypeActivityFormComponent },
  { path: 'typeActivities', component: TypeActivityListComponent },

  { path: 'rolForm', component: RolFormComponent },
  { path: 'updateRol/:rolId', component: RolFormComponent },
  { path: 'roles', component: RolListComponent },


  { path: '**', component: Page404Component }, 

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
