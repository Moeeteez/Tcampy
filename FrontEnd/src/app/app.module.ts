import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderAdminComponent } from './backOffice/header-admin/header-admin.component';
import { FooterAdminComponent } from './backOffice/footer-admin/footer-admin.component';
import { SideAdminComponent } from './backOffice/side-admin/side-admin.component';
import { BodyAdminComponent } from './backOffice/body-admin/body-admin.component';
import { AllTemplateAdminComponent } from './backOffice/all-template-admin/all-template-admin.component';
import { HeaderUserComponent } from './frontOffice/header-user/header-user.component';
import { FooterUserComponent } from './frontOffice/footer-user/footer-user.component';
import { BodyUserComponent } from './frontOffice/body-user/body-user.component';
import { AllTemplateUserComponent } from './frontOffice/all-template-user/all-template-user.component';
import { StoreComponent } from './frontOffice/store/store.component';
import { ItemComponent } from './frontOffice/item/item.component';
import { CardlistComponent } from './frontOffice/cardlist/cardlist.component';
import {HttpClientModule} from "@angular/common/http";
import { StoreDashboardComponent } from './backOffice/store-dashboard/store-dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {MatButtonModule} from '@angular/material/button';
import { AddProductComponent } from './backOffice/add-product/add-product.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTableModule} from '@angular/material/table';
import { ShowProductDetailsComponent } from './backOffice/show-product-details/show-product-details.component';
import {MatIconModule} from '@angular/material/icon';



@NgModule({
  declarations: [
    AppComponent,
    HeaderAdminComponent,
    FooterAdminComponent,
    SideAdminComponent,
    BodyAdminComponent,
    AllTemplateAdminComponent,
    HeaderUserComponent,
    FooterUserComponent,
    BodyUserComponent,
    AllTemplateUserComponent,
    StoreComponent,
    ItemComponent,
    CardlistComponent,
    StoreDashboardComponent,
    AddProductComponent,
    ShowProductDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule,
    RouterModule,
    MatButtonModule,
    MatGridListModule,
    MatTableModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
