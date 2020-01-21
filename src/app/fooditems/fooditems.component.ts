import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FooditemService } from '../fooditem.service';

@Component({
  selector: 'app-fooditems',
  templateUrl: './fooditems.component.html',
  styleUrls: ['./fooditems.component.css']
})
export class FooditemsComponent implements OnInit {
  fooditem = [];
  fooditemlist:Observable<[]>
  
  

  constructor(private fooditemservice: FooditemService) { }

  ngOnInit() {
    this.load();
    
  }
  load(){
  //  this.fooditemservice.getAllFoodItemDetail.subscribe(
    //  (response)=>{
       // this.fooditem=response;
    //  },
     // (err)=>{
      //  this.fooditem=[];
   //  // }
 ///   )
  };

}
