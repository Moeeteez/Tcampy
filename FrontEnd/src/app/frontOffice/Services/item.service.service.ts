import { Injectable } from '@angular/core';
import * as http from "http";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ItemServiceService {

  constructor(private http: HttpClient) {}


}
