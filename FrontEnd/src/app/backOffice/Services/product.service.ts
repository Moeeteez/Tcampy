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
}
