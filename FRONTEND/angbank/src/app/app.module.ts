import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/shared/home/home.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { TopbarComponent } from './components/shared/topbar/topbar.component';
import { DashboardComponent } from './components/shared/dashboard/dashboard.component';
import { LoginComponent } from './components/shared/login/login.component';
import { ActivityFormComponent } from './components/admin/activity-form/activity-form.component';
import { CreditFormComponent } from './components/admin/credit-form/credit-form.component';
import { UserFormComponent } from './components/admin/user-form/user-form.component';
import { UserListComponent } from './components/admin/user-list/user-list.component';
import { ActivityListComponent } from './components/admin/activity-list/activity-list.component';
import { CreditListComponent } from './components/admin/credit-list/credit-list.component';
import { Page404Component } from './components/shared/page404/page404.component';
import { UserViewComponent } from './components/admin/user-view/user-view.component';
import { TypeActivityFormComponent } from './components/admin/setting/typeActivity/type-activity-form/type-activity-form.component';
import { TypeActivityListComponent } from './components/admin/setting/typeActivity/type-activity-list/type-activity-list.component';
import { RolListComponent } from './components/admin/setting/rol/rol-list/rol-list.component';
import { RolFormComponent } from './components/admin/setting/rol/rol-form/rol-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SidebarComponent,
    FooterComponent,
    TopbarComponent,
    DashboardComponent,
    LoginComponent,
    ActivityFormComponent,
    CreditFormComponent,
    CreditListComponent,
    UserFormComponent,
    UserListComponent,
    ActivityListComponent,
    Page404Component,
    UserViewComponent,
    TypeActivityFormComponent,
    TypeActivityListComponent,
    RolListComponent,
    RolFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
