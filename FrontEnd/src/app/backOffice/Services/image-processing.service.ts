import { Injectable } from '@angular/core';
import {Product} from "../Models/product.model";
import {FileHandle} from "../Models/FileHandle.model";

@Injectable({
  providedIn: 'root'
})
export class ImageProcessingService {

  constructor() { }

  public createImages( product: Product) {
  const productImages: any [] = product.productImages ;

  const productImagesToFileHandle: FileHandle [] =[] ;

  for ( let i=0 ; i< productImages.length ; i++){
    const imageFileData = productImages[i] ;

    this.dataURItoBlob(imageFileData.picByte , imageFileData.type);
  }
  }
  public dataURItoBlob(picBytes : any,imageType : any){
    const byteString = window.atob(picBytes);
    const arrayBuffer = new ArrayBuffer(byteString.length);
    const int8Array = new Uint8Array(arrayBuffer) ;
    for(let i=0 ; i< byteString.length ; i++) {
      int8Array[i] = byteString.charCodeAt(i);

    }
  const blob =  new Blob([int8Array],{type : imageType});
  return blob ;
  }
}
