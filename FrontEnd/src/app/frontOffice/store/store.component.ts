import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../backOffice/Services/product.service";
import {map} from "rxjs";
import {Product} from "../../backOffice/Models/product.model";
import {HttpErrorResponse} from "@angular/common/http";
import {ImageProcessingService} from "../../backOffice/Services/image-processing.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {
  productDetails: Product [] = [] ;
  constructor(private productService: ProductService,
  private  imageProcessingService : ImageProcessingService,
  private router:Router) { }

  ngOnInit(): void {
    this.getAllProducts()
;  }
  public getAllProducts() {
    this.productService.getAllProducts()
      .pipe(
        map((x: Product [], i) =>x.map((product: Product) => this.imageProcessingService.createImages(product)))
      )
      .subscribe(
        (resp:Product [] )=> {
          console.log(resp);
          this.productDetails=resp ;
        },(error:HttpErrorResponse)=> {
          console.log(error)
        }
      );
  }
  showProductDetails(idProduct : any){
    this.router.navigate(['/itemDetails',{idProduct : idProduct}])

  }

}
