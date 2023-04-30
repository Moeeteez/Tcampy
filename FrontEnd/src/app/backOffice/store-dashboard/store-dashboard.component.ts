import { Component, OnInit } from '@angular/core';
import {ProductService} from "../Services/product.service";
import {Product} from "../Models/product.model";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-store-dashboard',
  templateUrl: './store-dashboard.component.html',
  styleUrls: ['./store-dashboard.component.scss']
})
export class StoreDashboardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

  }

}
