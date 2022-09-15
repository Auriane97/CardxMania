import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carte, Exemplaire } from 'src/model';
import { SearchService } from './search-http.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  recherche: string;

  cartes: Array<Carte> = new Array<Carte>();

  constructor(private router: Router, private searchService: SearchService) { }

  ngOnInit(): void {
  }

  search(): Array<Carte> {
    if (this.recherche) {
      return this.searchService.findAllByLibelle(this.recherche);
    }
    return this.searchService.findAll();
  }

}
