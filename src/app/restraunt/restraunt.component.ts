import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RestrauntService } from '../restraunt.service';
import {Restaurant} from '../restraunt';

@Component({
  selector: 'app-restraunt',
  templateUrl: './restraunt.component.html',
  styleUrls: ['./restraunt.component.css']
})
export class RestrauntComponent implements OnInit {
   restraunt = [];

  restrauntlist: Observable<[]>

  constructor(private restrauntservice: RestrauntService) { }

  ngOnInit() {
    this.loadData();
  }
  loadData() {


    this.restrauntservice.getAllRestaurantDetails().subscribe(
      (res) => {
      this.restraunt=res;
    },
    (err)=>{
      this.restraunt=[];
    }
    )
  };
}


