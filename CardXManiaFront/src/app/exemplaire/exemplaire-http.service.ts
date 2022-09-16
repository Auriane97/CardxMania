import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Carte, Exemplaire } from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class ExemplaireHttpService {

  exemplaires: Array<Exemplaire> = new Array<Exemplaire>();
  cartes: Array<Carte> = new Array<Carte>();
  recherche: string;
  apiPath: string;
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.apiPath = this.appConfig.apiBackEndUrl + "exemplaire/";
    this.load();
  }

  load() {
    this.http.get<Array<Exemplaire>>(this.apiPath).subscribe(response => {
      this.exemplaires = response;
    });

    this.http.get<Array<Carte>>(this.appConfig.apiBackEndUrl+"carte").subscribe(response => {
      this.cartes = response;
    });
  }

  findAll(): Array<Exemplaire> {
    return this.exemplaires;
  }

  findAllCartes(): Array<Carte> {
    return this.cartes;
  }

  findById(id: number): Observable<Exemplaire> {
    return this.http.get<Exemplaire>(this.apiPath+id);  
  }

  findByCarte(id: number): Array <Exemplaire> {
   // return this.http.get<Array<Exemplaire>>(this.apiPath+"carte/"+id);
    return this.exemplaires;
  }

  findByEtat(etat: string){

  }


  findByEnVente(enVente: boolean){

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
