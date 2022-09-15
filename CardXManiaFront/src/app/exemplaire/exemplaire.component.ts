import { Component, OnInit } from '@angular/core';
import { Achat, Carte, Compte, Exemplaire } from 'src/model';
import { ExemplaireHttpService } from './exemplaire-http.service';

@Component({
  selector: 'app-exemplaire',
  templateUrl: './exemplaire.component.html',
  styleUrls: ['./exemplaire.component.css']
})
export class ExemplaireComponent implements OnInit {

  formExemplaire: Exemplaire;

  constructor(private exemplaireService: ExemplaireHttpService) { }

  ngOnInit(): void {
  }

  list(): Array<Exemplaire> {
    return this.exemplaireService.findAll();
  }

  add() {
    this.formExemplaire = new Exemplaire();
    this.formExemplaire.carte = new Carte();
    this.formExemplaire.user = new Compte();
    this.formExemplaire.achats = new Array<Achat>();
  }

  edit(id: number) {
    this.exemplaireService.findById(id).subscribe(resp => {
      this.formExemplaire = resp;

      if(!this.formExemplaire.carte) {
        this.formExemplaire.carte = new Carte();
      }
      if(!this.formExemplaire.user) {
        this.formExemplaire.user = new Compte();;
      }

      if(!this.formExemplaire.achats) {
        this.formExemplaire.achats = new Array<Achat>();
      }
    });
  }

  save() {
    this.exemplaireService.save(this.formExemplaire);
    
    this.cancel();
  }

  cancel() {
    this.formExemplaire = null;
  }

  delete(id: number) {
    this.exemplaireService.delete(id);
  }
}
