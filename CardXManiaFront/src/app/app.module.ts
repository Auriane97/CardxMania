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
import { CompteHttpService } from './login/compte-http.service';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    CreateComponent,
    ExemplaireComponent,
    LoginComponent,
    SearchComponent,
   
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
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
