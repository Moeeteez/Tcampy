import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AllTemplateAdminComponent} from "./backOffice/all-template-admin/all-template-admin.component";
import {BodyAdminComponent} from "./backOffice/body-admin/body-admin.component";
import {AllTemplateUserComponent} from "./frontOffice/all-template-user/all-template-user.component";
import {BodyUserComponent} from "./frontOffice/body-user/body-user.component";
import {StoreComponent} from "./frontOffice/store/store.component";
import {ItemComponent} from "./frontOffice/item/item.component";
import {CardlistComponent} from "./frontOffice/cardlist/cardlist.component";
import {StoreDashboardComponent} from "./backOffice/store-dashboard/store-dashboard.component";
import {AddProductComponent} from "./backOffice/add-product/add-product.component";
import {ShowProductDetailsComponent} from "./backOffice/show-product-details/show-product-details.component";
import {ProductResolveService} from "./backOffice/Services/product-resolve.service";
import {BuyProductComponent} from "./frontOffice/buy-product/buy-product.component";
import {BuyProductResolverService} from "./frontOffice/Services/buy-product-resolver.service";

const routes: Routes = [
  {path:'admin', component:AllTemplateAdminComponent, children:[
      {path:'admin', component:BodyAdminComponent},
      {path: 'storedashboard', component: StoreDashboardComponent},

    ]},
  {path:'showproductdetails', component: ShowProductDetailsComponent},
  {path: 'products', component: AddProductComponent, resolve: {product: ProductResolveService}},

  {path:'', component: AllTemplateUserComponent, children:[
      {path:'user', component: BodyUserComponent},
      {path:'store', component: StoreComponent},
      {path:'itemDetails', component: ItemComponent, resolve: {product: ProductResolveService}},
      {path:'cardlist', component: CardlistComponent},
      {path:'buyProduct', component: BuyProductComponent ,  resolve: {productDetails: BuyProductResolverService}}]

  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
