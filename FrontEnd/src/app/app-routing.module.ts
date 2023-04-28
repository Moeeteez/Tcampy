import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AllTemplateAdminComponent} from "./backOffice/all-template-admin/all-template-admin.component";
import {BodyAdminComponent} from "./backOffice/body-admin/body-admin.component";
import {AllTemplateUserComponent} from "./frontOffice/all-template-user/all-template-user.component";
import {BodyUserComponent} from "./frontOffice/body-user/body-user.component";
import {StoreComponent} from "./frontOffice/store/store.component";
import {ItemComponent} from "./frontOffice/item/item.component";
import {CardlistComponent} from "./frontOffice/cardlist/cardlist.component";

const routes: Routes = [
  {
    path:'admin',
    component:AllTemplateAdminComponent,
    children:[
      {
        path:'admin',
        component:BodyAdminComponent
      }
    ]

  },
  {
    path:'',
    component: AllTemplateUserComponent,
    children:[
      {
        path:'user',
        component: BodyUserComponent
      },
      {
        path:'store',
        component: StoreComponent
      },
      {
        path:'item',
        component: ItemComponent
      },
      {
        path:'cardlist',
        component: CardlistComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
