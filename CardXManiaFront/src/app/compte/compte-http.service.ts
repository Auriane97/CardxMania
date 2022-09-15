import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Compte } from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class CompteHttpService {

  comptes: Array<Compte> = new Array<Compte>();

  apiPath: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.apiPath = this.appConfig.apiBackEndUrl + "compte/";
    this.load();
  }

  load() {
    this.http.get<Array<Compte>>(this.apiPath).subscribe(response => {
      this.comptes = response;
    });
  }

  findAll(): Array<Compte> {
    return this.comptes;
  }

  findById(id: number): Observable<Compte> {
    return this.http.get<Compte>(this.apiPath+id);
  }

  save(compte: Compte) {
    if(compte.id) { 
      this.http.put<Compte>(this.apiPath + compte.id, compte)
        .subscribe(resp => {
          this.load();
        });
    } else { 
      this.http.post<Compte>(this.apiPath, compte)
        .subscribe(resp => {
          this.load();
        });
    }
  }

  delete(id: number) {
    this.http.delete<void>(this.apiPath + id)
      .subscribe(resp => {
        this.load();
      });
  }
}
