import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddPostService } from '../add-post.service';

@Component({
  selector: 'app-logreg',
  templateUrl: './logreg.component.html',
  styleUrls: ['./logreg.component.css']
})
export class LogregComponent implements OnInit {
login:any=FormGroup
register:any=FormGroup
ngOnInit():void{
  this.login=this.formbuilder.group({
    username:[null],
    password:[null]
  })



}
constructor(private formbuilder:FormBuilder,private rout:Router,private servicelogin:AddPostService){}
handlelogin(){
  const formdata=this.login.value
  
  this.servicelogin.login(formdata).subscribe((response:any)=>{
this.rout.navigate(['home'])
localStorage.setItem('token',response.authenticationToken)
console.log(response)
  })
}

}
