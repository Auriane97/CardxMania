import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { Compte } from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  compte: Compte;
  utilisateur: Compte;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { }

  login(pseudo: string, password: string): Observable<Compte> {
    return this.http.post<Compte>(this.appConfig.apiBackEndUrl + "compte/login", {
      "pseudo": pseudo,
      "password": password
    });
  }
}
