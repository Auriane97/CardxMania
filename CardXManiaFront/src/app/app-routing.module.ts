import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './acceuil/home.component';
import { CartComponent } from './cart/cart.component';
import { ExemplaireComponent } from './exemplaire/exemplaire.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  { path: "", component: HomeComponent, pathMatch: "full" },
  { path: "exemplaire", component: ExemplaireComponent },
  { path: "search", component: SearchComponent},
  { path: "cart", component: CartComponent},
  { path: "login", component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
