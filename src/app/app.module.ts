import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LoginService } from './login.service';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { RestrauntComponent } from './restraunt/restraunt.component';

import { RestrauntService } from './restraunt.service';
import { FooditemsComponent } from './fooditems/fooditems.component';

@NgModule({
  declarations: [
    AppComponent,

    LoginComponent,

    RestrauntComponent,

  

    FooditemsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [LoginService,RestrauntService],
  bootstrap: [AppComponent]
})
export class AppModule { }
