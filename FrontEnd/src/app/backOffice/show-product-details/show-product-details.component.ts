import { Component, OnInit } from '@angular/core';
import {Product} from "../Models/product.model";
import {HttpErrorResponse} from "@angular/common/http";
import {ProductService} from "../Services/product.service";
import {MatDialog} from "@angular/material/dialog";
import {ShowImagesDialogComponent} from "../show-images-dialog/show-images-dialog.component";

@Component({
  selector: 'app-show-product-details',
  templateUrl: './show-product-details.component.html',
  styleUrls: ['./show-product-details.component.scss']
})
export class ShowProductDetailsComponent implements OnInit {
  productDetails: Product [] = [] ;
  displayedColumns: string[] = ['Id', 'Name', 'Type', 'Quantity','Description','Order type','Price Rental','Price Sale','Active','Images','Edit','Delete' ];

  constructor(private  productService: ProductService ,
              public  imagesDialoge: MatDialog) { }

  ngOnInit(): void {
    this.getAllProducts();
  }
  public getAllProducts() {
    this.productService.getAllProducts().subscribe(
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
    height:'400px',
    width : '700px'
  }) ;
  }
}
