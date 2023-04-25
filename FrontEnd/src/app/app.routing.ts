import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AdminLayoutComponent } from './backOffice/layouts/admin-layout/admin-layout.component';
import {AlltemplateUserComponent} from "./frontOffice/alltemplate-user/alltemplate-user.component";
import * as path from "path";
import {BodyUserComponent} from "./frontOffice/body-user/body-user.component";

const routes: Routes =[
  {
    path:'user',
    component:AlltemplateUserComponent,
    children :[
      {
        path: 'home',
        component: BodyUserComponent
      }
    ]
  },
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  }, {
    path: '',
    component: AdminLayoutComponent,
    children: [
        {
      path: '',
      loadChildren: () => import('./backOffice/layouts/admin-layout/admin-layout.module').then(x => x.AdminLayoutModule)
  }]},
  {
    path: '**',
    redirectTo: 'dashboard'
  }

];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes,{
       useHash: true
    })
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
