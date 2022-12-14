import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CartComponent } from './cart/cart.component';
import { CreateComponent } from './create/create.component';
import { ExemplaireComponent } from './exemplaire/exemplaire.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './search/search.component';
import { APIInterceptor } from './api.interceptor';
import { CompteHttpService } from './compte/compte-http.service';
import { FormsModule } from '@angular/forms';
import { CompteComponent } from './compte/compte.component';
import { ExemplaireHttpService } from './exemplaire/exemplaire-http.service';
import { SearchService } from './search/search-http.service';
import { AdminComponent } from './admin/admin.component';



@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    CreateComponent,
    ExemplaireComponent,
    LoginComponent,
    SearchComponent,
    CompteComponent,
    AdminComponent,
   
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: APIInterceptor, multi: true }, 
    
    CompteHttpService,
    ExemplaireHttpService,
    SearchService
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
