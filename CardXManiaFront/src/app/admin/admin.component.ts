import { Component, OnInit } from '@angular/core';
import { Compte } from 'src/model';
import { CompteHttpService } from '../compte/compte-http.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  formCompte: Compte;

  constructor(private compteService: CompteHttpService) { }

  ngOnInit(): void {
  }

  list(): Array<Compte> {
    return this.compteService.findAll();
  }

  add() {
    this.formCompte = new Compte();
    
  }

  

  save() {
    this.compteService.save(this.formCompte);

    this.cancel();
  }

  cancel() {
    this.formCompte = null;
  }

  delete(id: number) {
    this.compteService.delete(id);
  }
}
