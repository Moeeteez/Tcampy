import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../Models/product.model";
import {OrderDetails} from "../../frontOffice/Models/order-details.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient :HttpClient) { }

public addProduct( product :FormData){
    return this.httpClient.post<Product>("http://localhost:8009/Product/add",product)
}
  public getAllProducts(pageNumber : any , searchKey : string =""){
    return this.httpClient.get<Product[]>("http://localhost:8009/Product/getAll?pageNumber="+pageNumber+"&searchKey="+searchKey);
  }
  public  deleteProduct(idProduct: number){
   return  this.httpClient.delete("http://localhost:8009/Product/delete/"+idProduct)
  }


  public  getProductDetailsById(idProduct : any){
    return  this.httpClient.get<Product>("http://localhost:8009/Product/get/"+idProduct)
  }


  public getProductDetails(isSingleProductCheckout : any, productId:any) {
    return this.httpClient.get<Product[]>("http://localhost:8009/Product/getProductDetails/"+isSingleProductCheckout+"/"+productId);
  }

  public placeOrder(orderDetails: OrderDetails){
    return this.httpClient.post("http://localhost:8009/orders/placeOrder", orderDetails) ;
  }

  public  addToCart (productId : any){
    return this.httpClient.get("http://localhost:8009/addToCart/"+productId)
  }

  public getCartDetails() {
    return this.httpClient.get("http://localhost:8009/getCartDetails");
  }


  public deleteCartItem(cartId : any) {
    return this.httpClient.delete("http://localhost:8009/deleteCartItem/"+cartId);
  }
}
