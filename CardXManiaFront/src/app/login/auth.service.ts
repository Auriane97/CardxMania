import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpCompte } from '@angular/common/http';
import { AppConfigService } from './app-config.service';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  compte: Compte;

  constructor(private http: HttpCompte, private appConfig: AppConfigService) { }

  login(pseudo: string, password: string): Observable<Compte> {
    return this.http.post<Compte>(this.appConfig.apiBackEndUrl + "compte/login", {
      "pseudo": pseudo,
      "password": password
    });
  }
}
