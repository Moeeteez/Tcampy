import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddPostService } from '../add-post.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
registerform:any=FormGroup
  ngOnInit():void{

    this.registerform=this.formbuilder.group({
      email:[null],
      username:[null],
      password:[null]
    })
  
  
  }
  constructor(private formbuilder:FormBuilder,private rout:Router,private servicelogin:AddPostService){}
  handleregister(){
    const formdata=this.registerform.value
    
    this.servicelogin.register(formdata).subscribe((response=>{
  this.rout.navigate(['login'])
  }))
  }
}
