import { Component, OnInit } from '@angular/core';
import {Product} from "../Models/product.model";
import {HttpErrorResponse} from "@angular/common/http";
import {ProductService} from "../Services/product.service";

@Component({
  selector: 'app-show-product-details',
  templateUrl: './show-product-details.component.html',
  styleUrls: ['./show-product-details.component.scss']
})
export class ShowProductDetailsComponent implements OnInit {
  productDetails: Product [] = [] ;
  displayedColumns: string[] = ['Id', 'Name', 'Type', 'Quantity','Description','Order', 'type','Price Rental','Price Sale','Active' ];

  constructor(private  productService: ProductService) { }

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
}
