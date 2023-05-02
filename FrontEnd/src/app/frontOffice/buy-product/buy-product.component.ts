import { Component, OnInit } from '@angular/core';
import {Product} from "../../backOffice/Models/product.model";
import {ActivatedRoute, Router} from "@angular/router";
import {OrderDetails} from "../Models/order-details.model";
import {ProductService} from "../../backOffice/Services/product.service";
import {NgForm} from "@angular/forms";

declare var Razorpay: any;



@Component({
  selector: 'app-buy-product',
  templateUrl: './buy-product.component.html',
  styleUrls: ['./buy-product.component.scss']
})
export class BuyProductComponent implements OnInit {
  isSingleProductCheckout: string = '';
  productDetails: Product[] = [] ;

  orderDetails: OrderDetails = {
    fullName: '',
    fullAddress: '',
    contactNumber: '',
    alternateContactNumber: '',
    transactionId: '',
    orderProductQuantityList: []
  }

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private router : Router) { }

  ngOnInit(): void {
    this.productDetails = this.activatedRoute.snapshot.data['productDetails'];

    this.productDetails.forEach(
      x => this.orderDetails.orderProductQuantityList.push(
        {productId: x.idProduct, quantity: 1}
      )
    );

    console.log(this.productDetails)
    console.log(this.orderDetails);
  }

  public placeOrder(orderForm: NgForm) {
    this.productService.placeOrder(this.orderDetails).subscribe(
      (resp) => {
        console.log(resp);
        orderForm.reset();
        this.router.navigate(["/orderConfirm"])
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getQuantityForProduct(productId: any) {
    const filteredProduct = this.orderDetails.orderProductQuantityList.filter(
      (productQuantity) => productQuantity.productId === productId
    );

    return filteredProduct[0].quantity;
  }

  getCalculatedTotal(productId : any, productDiscountedPrice :any) {
    const filteredProduct = this.orderDetails.orderProductQuantityList.filter(
      (productQuantity) => productQuantity.productId === productId
    );

    return filteredProduct[0].quantity * productDiscountedPrice;
  }

  onQuantityChanged(q: any, productId : any) {
    this.orderDetails.orderProductQuantityList.filter(
      (orderProduct) => orderProduct.productId === productId
    )[0].quantity = q;
  }

  getCalculatedGrandTotal() {
    let grandTotal = 0;

    this.orderDetails.orderProductQuantityList.forEach(
      (productQuantity) => {
        const price = this.productDetails.filter(product => product.idProduct === productQuantity.productId)[0].priceSale;
        grandTotal = grandTotal + price * productQuantity.quantity;
      }
    );

    return grandTotal;
  }


  createTransactionAndPlaceOrder(orderForm: NgForm) {
    let amount = this.getCalculatedGrandTotal();
    this.productService.createTransaction(amount).subscribe(
      (response) => {
        console.log(response);
        this.openTransactioModal(response, orderForm);
      },
      (error) => {
        console.log(error);
      }
    );
  }
    openTransactioModal(response: any, orderForm: NgForm) {
      var options = {
        order_id: response.orderId,
        key: response.key,
        amount: response.amount,
        currency: response.currency,
        name: 'Tcampy',
        description: 'Payment of online shopping',
        image: 'https://cdn.pixabay.com/photo/2023/01/22/13/46/swans-7736415_640.jpg',
        handler: (response: any) => {
          if(response!= null && response.razorpay_payment_id != null) {
            this.processResponse(response, orderForm);
          } else {
            alert("Payment failed..")
          }

        },
        prefill : {
          name:'Tcampy',
          email: 'Tcampy@GMAIL.COM',
          contact: '90909090'
        },
        notes: {
          address: 'Online Shopping'
        },
        theme: {
          color: '#F37254'
        }
      };

      var razorPayObject = new Razorpay(options);
      razorPayObject.open();
    }

    processResponse(resp: any, orderForm:NgForm) {
      this.orderDetails.transactionId = resp.razorpay_payment_id;
      this.placeOrder(orderForm);
    }


}
