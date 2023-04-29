import { Component, OnInit } from '@angular/core';
import {Product} from "../Models/product.model";
import {NgForm} from "@angular/forms";
import {ProductService} from "../Services/product.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {
  product: Product = {
    name : "" ,
    type : "" ,
    description :"",
    priceRental : 0.0,
    priceSale : 0.0 ,
    quantity :0.0 ,
    NbDaysForRental : 0.0 ,
  }


  constructor(private  productService :ProductService) { }

  ngOnInit(): void {
  }

  addProduct(productForm:NgForm) {
   this.productService.addProduct(this.product).subscribe(
     (response :Product)=> {
       console.log(response);
     },
     (error :HttpErrorResponse)=> {
       console.log(error);
     }
   )
  }

}
