import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exemplaire } from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class ExemplaireHttpService {

  exemplaires: Array<Exemplaire> = new Array<Exemplaire>();

  apiPath: string;
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.apiPath = this.appConfig.apiBackEndUrl + "exemplaire/";
    this.load();
  }

  load() {
    this.http.get<Array<Exemplaire>>(this.apiPath).subscribe(response => {
      this.exemplaires = response;
    });
  }

  findAll(): Array<Exemplaire> {
    return this.exemplaires;
  }

  findById(id: number): Observable<Exemplaire> {
    return this.http.get<Exemplaire>(this.apiPath+id);
  }

  save(exemplaire: Exemplaire) {
    if(exemplaire.id) { // modification
      this.http.put<Exemplaire>(this.apiPath + exemplaire.id, exemplaire)
        .subscribe(resp => {
          this.load();
        });
    } else { // création
      this.http.post<Exemplaire>(this.apiPath, exemplaire)
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
