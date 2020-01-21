import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestrauntService {
  private baseUrl= 'http://localhost:7070/project7/restaurant/';

  constructor(private http:HttpClient) { }
  getAllRestaurantDetails():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

}

