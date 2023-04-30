import {Component, Inject, Injectable, OnInit} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from "@angular/material/dialog";
import {FileHandle} from "../Models/FileHandle.model";

@Component({
  selector: 'app-show-images-dialog',
  templateUrl: './show-images-dialog.component.html',
  styleUrls: ['./show-images-dialog.component.scss']
})
export class ShowImagesDialogComponent implements OnInit {

  constructor(@Inject (MAT_DIALOG_DATA) public data : any) { }

  ngOnInit(): void {
    this.receiveImages() ;
  }
receiveImages() {
    console.log (this.data) ;
}
}
