import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RestrauntComponent } from './restraunt/restraunt.component';
import { FooditemsComponent } from './fooditems/fooditems.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'restro', component: RestrauntComponent },
  {path:'fooditems/:fooditem_id',component :FooditemsComponent}
]
  ;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
