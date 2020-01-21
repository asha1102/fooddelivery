import { Component, OnInit, Inject } from '@angular/core';
import { LoginService } from '../login.service';
import { Login } from 'src/Login';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Customer } from 'src/customer';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //loginForm: FormGroup;
  loggedIn:boolean;
  logindetails:Customer=new Customer();
  validCustomer: boolean;
c:Customer=new Customer();
msg:string;
loginstatus:boolean;
registerstatus:boolean;

  //constructor(private loginservice: LoginService, private fb: FormBuilder) {
    //this.createForm();
 // }
 constructor(private ls:LoginService, private fb: FormBuilder) { }

  ngOnInit() {
    this.ls.currentLoginState.subscribe(result=>this.loggedIn=result);
  }

  

  // createForm() {
    //this.loginForm = this.fb.group({
      //cemail: [''],
      //cpassword: ['']
    //})
  //}



  //userLogin() {
    //console.log(this.loginForm.value);
    //this.loginservice.authenticateCustomer(this.loginForm.value).subscribe((resp) => {
      //console.log(resp);
    //}, (err) => {
      //console.error(err); 
    //})
    // this.loginservice.authenticateCustomer({ LoginId: this.logindetails.LoginId, Password: this.logindetails.Password }).subscribe(data => this.loggedIn = data as boolean);
    // if (this.loggedIn == true) {
    //   this.loginservice.changecurrentLoginState(this.loggedIn);
    // }
  //}

  customerLogin()
  {
    this.ls.authenticateCustomer({email:this.logindetails.cemail,pass:this.logindetails.cpassword}).
   subscribe(data=>this.c=data as Customer);
   if(this.c.cphoneno!=null)
   {
     this.loginstatus=true;
     this.msg="Login Successful";
    this.ls.changecurrentLoginState(this.loginstatus);
    //this.storage.set('cust',JSON.stringify(this.c));
   }
   else
   {
this.msg="Login Failed "
   }
 }

}



