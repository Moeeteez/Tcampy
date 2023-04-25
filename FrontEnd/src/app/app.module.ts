import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app.routing';
import { NavbarModule } from './backOffice/shared/navbar/navbar.module';
import { FooterModule } from './backOffice/shared/footer/footer.module';
import { SidebarModule } from './backOffice/sidebar/sidebar.module';

import { AppComponent } from './app.component';

import { AdminLayoutComponent } from './backOffice/layouts/admin-layout/admin-layout.component';
import { HeaderUserComponent } from './frontOffice/header-user/header-user.component';
import { FooterUserComponent } from './frontOffice/footer-user/footer-user.component';
import { AlltemplateUserComponent } from './frontOffice/alltemplate-user/alltemplate-user.component';
import { BodyUserComponent } from './frontOffice/body-user/body-user.component';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    NavbarModule,
    FooterModule,
    SidebarModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    HeaderUserComponent,
    FooterUserComponent,
    AlltemplateUserComponent,
    BodyUserComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
