import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataAccessService {
  //pageId;
  constructor(
    private http: HttpClient,
    //private search: SearchBarComponent
    //private pages: PageListComponent
    ) {}
  executeDataAccessDefaultService(){
    console.log("Hi I am Data Access Default Service");
    return this.http.get("https://wikifend.herokuapp.com/");
  }
  
  executeDataAccessBeanService(){
    console.log("Hi I am Data Access Bean Service");
    return this.http.get("https://wikifend.herokuapp.com/helloworld-bean");
  }

  executeDataDeleteService(pageId1:any){

    console.log(pageId1);
    //let id=pageId1;
    //return this.http.get(`http://localhost:4402/delete/${pageId1}`);//But to catch this, there should be a request mapping with /delete/ in the path
    return this.http.delete(`https://wikifend.herokuapp.com/${pageId1}`);
  }

  executeDataSaveService(page2:any){
    
    console.log(page2);
    //let id=pageId1;
    return this.http.post('https://wikifend.herokuapp.com/',{ 'searchList' : page2 });
  }
}
