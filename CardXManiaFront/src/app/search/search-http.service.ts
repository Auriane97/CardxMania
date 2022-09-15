import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Carte } from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  cartes: Array<Carte> = new Array<Carte>();

  apiPath: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.apiPath = this.appConfig.apiBackEndUrl + "carte/";
    this.load();
  }

  load() {
    this.http.get<Array<Carte>>(this.apiPath).subscribe(response => {
      this.cartes = response;
    });
  }

  findAll(): Array<Carte> {
    return this.cartes;
  }

  findById(id: number): Observable<Carte> {
    return this.http.get<Carte>(this.apiPath+id);
  }
}
