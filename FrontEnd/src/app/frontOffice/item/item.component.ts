import { Component, OnInit } from '@angular/core';
import {Product} from "../../backOffice/Models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../backOffice/Services/product.service";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit {
  selectedProductIndex = 0;
  product: Product = {
    idProduct: null,
    name: "",
    type: "",
    description: "",
    priceRental: 0.0,
    priceSale: 0.0,
    quantity: 0.0,
    NbDaysForRental: 0.0,
    productImages: []
  }

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private productService: ProductService,) {
  }

  ngOnInit(): void {
    this.product = this.activatedRoute.snapshot.data['product'];
    console.log(this.product)
  }
  addtoCart(idProduct: any) {
    this.productService.addToCart(idProduct).subscribe(
      (response)=>{
        console.log(response) ;
      },(error)=> {
        console.log(error)
      }
    )

  }
  changeIndex(index: any) {
    this.selectedProductIndex = index;
  }

  buyProduct(productId : any) {
    this.router.navigate(['/buyProduct', {
      isSingleProductCheckout: true, id: productId
    }]);
  }

}


