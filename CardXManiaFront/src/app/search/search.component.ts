import { Component, OnInit } from '@angular/core';
import { Carte } from 'src/model';
import { SearchService } from './search-http.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {



  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
  }

  list(): Array<Carte> {
    return this.searchService.findAll();
  }

  

  edit(id: number) {
    this.searchService.findById(id);
  }

}
