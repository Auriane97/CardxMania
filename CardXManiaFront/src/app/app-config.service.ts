import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  apiBackEndUrl: string = "http://localhost:8080/api/";
  apiKey: string = "123456";
  constructor() { }
}
