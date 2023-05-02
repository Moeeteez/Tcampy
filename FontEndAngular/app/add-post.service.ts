import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddPostService {

  constructor(private httpClient: HttpClient) {
  }

  addPost(data:any){
    return this.httpClient.post('http://localhost:9092/SpringMVC/api/posts/',data,{
      headers:new HttpHeaders().set('content-type' ,'application/json')
    });
  }
  login(data:any){
    return this.httpClient.post('http://localhost:9092/SpringMVC/api/auth/login',data,{
      headers:new HttpHeaders().set('content-type' ,'application/json')
    });
  }

register(data:any){
    return this.httpClient.post('http://localhost:9092/SpringMVC/api/auth/signup',data,{
      headers:new HttpHeaders().set('content-type' ,'application/json')
    });
  }
  getpost(){
    return this.httpClient.get('http://localhost:9092/SpringMVC/api/posts/all')
  }
  reaction(data:any,post_id:any,user_id:any){
    return this.httpClient.post('http://localhost:9092/SpringMVC/api/posts/'+post_id+'/reactions/'+user_id,data,{
      headers:new HttpHeaders().set('content-type' ,'application/json')})

  }
  deletereaction(id:any){
    return this.httpClient.delete('http://localhost:9092/SpringMVC/api/posts/reactions/'+id)
  }
  getcurrentuser(){
    return this.httpClient.get(' http://localhost:9092/SpringMVC/api/auth/user')

  }

}

