import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Product} from "../Models/product.model";
import {map, Observable, of} from "rxjs";
import {ProductService} from "./product.service";
import {ImageProcessingService} from "./image-processing.service";

@Injectable({
  providedIn: 'root'
})
export class ProductResolveService implements  Resolve<Product>{

  constructor(private productService : ProductService,
              private  imageProcessingService: ImageProcessingService) { }

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):Observable<Product> {
    const id = route.paramMap.get("idProduct") ;

    if(id) {
      //fetch to backend
  return  this.productService.getProductDetailsById(id)
    .pipe(
      map(p =>this.imageProcessingService.createImages((p)))
    )
    }else {
      //return empty product observable
      return of(this.getProductDetails()) ;
    }
  }
  getProductDetails () {
    return {
      idProduct: null,
      name : "" ,
      type : "" ,
      description :"",
      priceRental : 0.0,
      priceSale : 0.0 ,
      quantity :0.0 ,
      NbDaysForRental : 0.0 ,
      productImages: []
    }
  }
}

