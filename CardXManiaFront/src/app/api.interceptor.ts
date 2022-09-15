import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';

@Injectable()
export class APIInterceptor implements HttpInterceptor {

  constructor(private appConfig: AppConfigService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const authReq = request.clone({
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'CARDXMANIA-KEY': this.appConfig.apiKey
      })
    });
    
    return next.handle(authReq);
  }
}
