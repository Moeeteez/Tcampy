import { Component, OnInit } from '@angular/core';
import {Product} from "../Models/product.model";
import {NgForm} from "@angular/forms";
import {ProductService} from "../Services/product.service";
import {HttpErrorResponse} from "@angular/common/http";
import {FileHandle} from "../Models/FileHandle.model";
import {DomSanitizer} from "@angular/platform-browser";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {
  isNewProduct = true ;
  product: Product = {
    idProduct : null ,
    name : "" ,
    type : "" ,
    description :"",
    priceRental : 0.0,
    priceSale : 0.0 ,
    quantity :0.0 ,
    NbDaysForRental : 0.0 ,
    productImages: []
  }


  constructor(private  productService :ProductService ,
              private  sanitizer : DomSanitizer,
              private activitedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.product = this.activitedRoute.snapshot.data['product'] ;
    if (this.product && this.product.idProduct){
      this.isNewProduct= false ;

    }
  }
  addProduct(productForm:NgForm) {
    const productFormData = this.prepareFormData(this.product);
   this.productService.addProduct(productFormData).subscribe(
     (response :Product)=> {
      productForm.reset()
     },
     (error :HttpErrorResponse)=> {
       console.log(error);
     })}
  prepareFormData(product: Product): FormData{
    const formData = new FormData() ;

    formData.append(
      'product',
      new Blob([JSON.stringify(product)],{type:'application/json'})
    );
    for ( var i=0 ; i<product.productImages.length; i++) {
      formData.append(
        'imageFile',
        product.productImages[i].file ,
        product.productImages[i].file.name ) ;
    }
    return  formData ;
  }
  onFileSelected({event}: { event: any }){
    if (event.target.files){
      const file = event.target.files[0];

      const fileHandle : FileHandle = {
        file : file,
        url : this.sanitizer.bypassSecurityTrustUrl(
          window.URL.createObjectURL(file)
        )

      }
      this.product.productImages.push(fileHandle) ;
    }
  }
  removeImage(i :number) {
    this.product.productImages.splice(i , 1)}
}
