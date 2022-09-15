import { Component, OnInit } from '@angular/core';
import { Compte } from 'src/model';
import { CompteHttpService } from './compte-http.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {

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

  edit(id: number) {
    this.compteService.findById(id).subscribe(resp => {
      this.formCompte = resp;

    });
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
