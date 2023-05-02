import { Component, OnInit } from '@angular/core';
import { AddPostService } from '../add-post.service';
import { FormGroup , FormControl,FormBuilder} from '@angular/forms';
import { statut } from './model';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
data:any
like:any
current:any
statut:statut[]=[]
id=this.route.snapshot.params['id']
  addpost:any=FormGroup ;
  constructor(private addpostService: AddPostService,private formBuilder:FormBuilder,private route:ActivatedRoute) {
    };
    ngOnInit():void{
      var current=this.getcurrentuser()
    

      this.getposts()
      this.addpost=this.formBuilder.group({
        content:[null] 
      })

    }



handlepost(){
var formdata=this.addpost.value
var data={
  content:formdata.content 
}


this.addpostService.addPost(data).subscribe((response=>{
  console.log(formdata.content)
}))
}
getposts(){
  this.addpostService.getpost().subscribe((response:any)=>{
this.statut=response

console.log(response)
  })
}
handlereaction(like:any,id:any,current:any){
  this.addpostService.reaction(this.like,this.id,this.current.id).subscribe((response:any)=>{


  })
}
getcurrentuser(){
  this.addpostService.getcurrentuser().subscribe((data=>{
   this.current=data
  
  }))
}
}
