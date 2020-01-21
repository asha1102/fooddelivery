import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FooditemService {

  private baseUrl='http://localhost:7070/project7/fooditem/';

  constructor(private http: HttpClient) { }
  getAllFoodItemDetail():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
}
