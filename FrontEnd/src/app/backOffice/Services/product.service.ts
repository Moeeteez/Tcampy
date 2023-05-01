import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../Models/product.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient :HttpClient) { }

public addProduct( product :FormData){
    return this.httpClient.post<Product>("http://localhost:8009/Product/add",product)
}
  public getAllProducts(){
    return this.httpClient.get<Product[]>("http://localhost:8009/Product/getAll")
  }
  public  deleteProduct(idProduct: number){
   return  this.httpClient.delete("http://localhost:8009/Product/delete/"+idProduct)
  }


  public  getProductDetailsById(idProduct : any){
    return  this.httpClient.get<Product>("http://localhost:8009/Product/get/"+idProduct)
  }
}