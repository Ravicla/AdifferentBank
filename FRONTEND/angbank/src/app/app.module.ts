import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserFormComponent } from './components/admin/user-form/user-form.component';
import { ViewComponent } from './components/customer/view/view.component';
import { RolFormComponent } from './components/admin/rol-form/rol-form.component';
import { UserListComponent } from './components/admin/user-list/user-list.component';
import { LoginComponent } from './components/shared/login/login.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    UserFormComponent,
    ViewComponent,
    RolFormComponent,
    UserListComponent,
    LoginComponent,
    SidebarComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
