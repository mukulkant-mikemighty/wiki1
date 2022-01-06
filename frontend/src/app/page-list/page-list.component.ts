import { Component, OnInit , Input, Output} from '@angular/core';
import {DataAccessService} from '../data-access.service';
import {AppComponent} from '../app.component';
import { analyzeAndValidateNgModules } from '@angular/compiler';

//import {SearchBarComponent} from '../search-bar/search-bar.component';
//import {SearchBarComponent} from '../search-bar/search-bar.component';
@Component({
  selector: 'app-page-list',
  templateUrl: './page-list.component.html',
  styleUrls: ['./page-list.component.css']
})
export class PageListComponent implements OnInit {
  //searchbarcomponent=SearchBarComponent;
  @Input() pages:any;
  @Input() searchVal:any;
  @Input() actionHide:any;
  resp1:any;
  resp:any;
  flag3:any;
  page:any;
  constructor(
    private dataAccess:DataAccessService,
    private appComponent: AppComponent,
    //private searchCompo: SearchBarComponent
    //private page=page
  ) { }


  ngOnInit(): void {
  //this.flag3=this.searchCompo.flag2;
  this.dataAccess.executeDataAccessDefaultService();
  
  }
  /*
  onPrevSearch1(){
    ////this.resp1=this.appComponent.flag;
    this.resp1=this.flag3 ^  this.appComponent.flag;
    return this.resp1;
  }
  */

  refreshPage(){
    this.dataAccess.executeDataAccessDefaultService().subscribe((response:any) => {
      this.pages=response;
      
    });
  }


  onDelRequest( pageId : string){
    this.dataAccess.executeDataDeleteService(pageId).subscribe((response:any)=>{
      console.log(this.resp = response);
      this.refreshPage();
      console.log("Sucessfully Deleted");
      
      //this.pages=this.resp;
      
    });
  }

}
