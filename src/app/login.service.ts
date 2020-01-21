import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subscription, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  [x: string]: any;


  private loggedIn = new BehaviorSubject<boolean>(false);
  private Registered= new BehaviorSubject<boolean>(false);
  currentLoginState = this.loggedIn.asObservable();
  currentRegisterState=this.Registered.asObservable();

  private baseUrl = 'http://localhost:7070/project7/customer/login';

  constructor(private http: HttpClient) { }

  authenticateCustomer(value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}`,value);    

   // return this.http.post(this.baseUrl, value,  {
    //  headers: new HttpHeaders()
      //  .set('Content-Type', 'application/x-www-form-urlencoded')
    //});

  }

  changecurrentLoginState(state: boolean) {

    this.loggedIn.next(state);
  }
  registerCustomer(value:any):Observable<any>
  {
    return this.http.post(`${this.baseUrl+'/custregister'}`,value);
  }
  changecurrentRegisterState(state:boolean)
  {    
    this.Registered.next(state);
  }

}