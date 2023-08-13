import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

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
import { UserCreditListComponent } from './components/admin/user-credit-list/user-credit-list.component';

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
    UserCreditListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
