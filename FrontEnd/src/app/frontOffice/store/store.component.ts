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
  showLoadButton = false ;
  pageNumber : number = 0 ;
  productDetails: Product [] = [] ;
  constructor(private productService: ProductService,
  private  imageProcessingService : ImageProcessingService,
  private router:Router) { }

  ngOnInit(): void {
    this.getAllProducts()
;  }
  public getAllProducts() {
    this.productService.getAllProducts(this.pageNumber)
      .pipe(
        map((x: Product [], i) =>x.map((product: Product) => this.imageProcessingService.createImages(product)))
      )
      .subscribe(
        (resp:Product [] )=> {
          console.log(resp);
          if(resp.length ==1){
            this.showLoadButton = true ;
          }else {
            this.showLoadButton = false ;
          }
          resp.forEach(p => this.productDetails.push(p))
          //this.productDetails=resp ;
        },(error:HttpErrorResponse)=> {
          console.log(error)
        }
      );
  }
  showProductDetails(idProduct : any){
    this.router.navigate(['/itemDetails',{idProduct : idProduct}])

  }
  public loadMoreProduct() {
    this.pageNumber=this.pageNumber +1 ;
    this.getAllProducts();
  }

}
