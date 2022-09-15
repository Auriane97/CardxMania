import { Injectable } from '@angular/core';
import { HttpCompte } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  comptes: Array<Compte> = new Array<Compte>();

  apiPath: string;

  constructor(private http: HttpCcompte, private appConfig: AppConfigService) {
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
    if(compte.id) { // modification
      this.http.put<Compte>(this.apiPath + compte.id, compte)
        .subscribe(resp => {
          this.load();
        });
    } else { // création
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
