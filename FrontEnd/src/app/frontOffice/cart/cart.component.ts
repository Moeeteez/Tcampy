import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../backOffice/Services/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  displayedColumns: string[] = ['Name', 'Description', 'Price', 'Type', 'Action'];

  cartDetails: any[] = [];

  constructor(private productService: ProductService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getCartDetails();
  }

  // delete(cartId :any) {
  //   console.log(cartId);
  //   this.productService.deleteCartItem(cartId).subscribe(
  //     (resp) => {
  //       console.log(resp);
  //       this.getCartDetails();
  //     }, (err) => {
  //       console.log(err);
  //     }
  //   );
  // }

  getCartDetails() {
    this.productService.getCartDetails().subscribe(
      (response: any) => {
        console.log(response);
        this.cartDetails = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  checkout() {

    this.router.navigate(['/buyProduct', {
      isSingleProductCheckout: false, id: 0
    }]);
  }
}
