import {FileHandle} from "./FileHandle.model";

export  interface Product {
  idProduct : any ;
  name:String ;
  type:String ;
  description:String ;
  priceRental :number ;
  priceSale :number ;
  quantity:number ;
  NbDaysForRental :number ;
  productImages : FileHandle[] ;

}
