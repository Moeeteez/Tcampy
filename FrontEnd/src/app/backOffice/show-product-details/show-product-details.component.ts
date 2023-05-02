import { Component, OnInit } from '@angular/core';
import {Product} from "../Models/product.model";
import {HttpErrorResponse} from "@angular/common/http";
import {ProductService} from "../Services/product.service";
import {MatDialog} from "@angular/material/dialog";
import {ShowImagesDialogComponent} from "../show-images-dialog/show-images-dialog.component";
import {ImageProcessingService} from "../Services/image-processing.service";
import {map} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-show-product-details',
  templateUrl: './show-product-details.component.html',
  styleUrls: ['./show-product-details.component.scss']
})
export class ShowProductDetailsComponent implements OnInit {
  productDetails: Product [] = [] ;
  displayedColumns: string[] = ['Id', 'Name', 'Type', 'Quantity','Description','Order type','Price Rental','Price Sale','Active','Actions' ];

  constructor(private  productService: ProductService ,
              public  imagesDialoge: MatDialog,
              private imageProcessingService : ImageProcessingService,
              private router:Router) { }

  ngOnInit(): void {
    this.getAllProducts();
  }
  public getAllProducts() {
    this.productService.getAllProducts(0)
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
  deleteProduct(idProduct: any){
    this.productService.deleteProduct(idProduct).subscribe(
      (resp)=>{
    this.getAllProducts();
      },
      (error:HttpErrorResponse) => {
        console.log(error)
      }
      );
  }

  showImages(product: Product) {
  this.imagesDialoge.open(ShowImagesDialogComponent, {
    data : {
      images : product.productImages
    },
    height:'400px',
    width : '700px'
  }) ;
  }

  editProductDetails(idProduct : any) {
this.router.navigate(['/products',{idProduct:idProduct}])

  }
}
