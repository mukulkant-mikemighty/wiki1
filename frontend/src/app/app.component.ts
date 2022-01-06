import { Component } from '@angular/core';
import { WikipediaService } from './wikipedia.service';
import { DataAccessService } from './data-access.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'wikiSearch3';
  pages :any;
  search = '';
  actionHide = true;
  wow:any;
  len:any;
  flag:any;
  constructor(
    private wikipedia: WikipediaService,
    private dataAccess: DataAccessService
  ) {

  }

  onPrevSearch() {
    this.actionHide = true;
    this.dataAccess.executeDataAccessDefaultService().subscribe(response => {
      //this.resp = response;
      this.pages = response;
      this.flag = true;
      this.search = "Previous Searches";
    });
  }


  submitVal(val:any) {
    console.log(val);
    this.actionHide = false;
    this.search = val;
    /*for (let index = 0; index < this.pages.length; index++) {
      const element = this.pages[index];
      this.dataAccess.executeDataSaveService(element).subscribe((response:any)=>{
        console.log("Saved?"+index);
      });  
    }*/


  }


  /*
   this.dataAccess.executeDataAccessBeanService().subscribe((response:any)=>{
    //console.log(this.dataAccess.executeDataAccessBeanService());
    //console.log(JSON.parse(this.dataAccess.executeDataAccessBeanService()).recrdset);
    console.log(response);
    ////this.wow=response;//[0].message();
    ////let dataWow=this.wow;
    ////console.log(dataWow.message);////these work
    ///console.log(response.message);//this also works
    
    //this.wow= JSON.parse(response).recordset;
    //let wow= response.dataAccess.executeDataAccessBeanService();
    //console.log(JSON.stringify(this.wow)); 
  });
  */

  onTerm(term: string) {
    //console.log('I am the app and here is the term:', term);
    //const results=this.wikipedia.search(term);
    //console.log(results);
    this.wikipedia.search(term).subscribe((response: any) => {
      //console.log(response);
      this.actionHide = false;
      this.pages = response.query.search;
      this.pages.map((o:any) => {
        o['pageId'] = '' + o.pageid;
        o['wordCount'] = '' + o.wordcount;


      });

      this.dataAccess.executeDataSaveService(this.pages).subscribe((response: any) => {
        console.log("Saved?");
      });

      this.len=this.pages.length;
      //check the structure of response json for details
    });

    // for (let index = 0; index < this.pages.length; index++) {
    //   const element = this.pages[index];
    //   this.dataAccess.executeDataSaveService(element).subscribe((response:any)=>{
    //     console.log("Saved?"+index);
    //   });  
    // }
    //err=>{console.error(err)};
  }
}



