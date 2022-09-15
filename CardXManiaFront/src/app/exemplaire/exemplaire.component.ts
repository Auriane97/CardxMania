import { Component, OnInit } from '@angular/core';
import { Achat, Carte, Compte, Exemplaire, User } from 'src/model';
import { ExemplaireHttpService } from './exemplaire-http.service';

@Component({
  selector: 'app-exemplaire',
  templateUrl: './exemplaire.component.html',
  styleUrls: ['./exemplaire.component.css']
})
export class ExemplaireComponent implements OnInit {

  formExemplaire: Exemplaire;
  user: User;
  valueCarte: Carte;
  achats: Array<Achat>;

  constructor(private exemplaireService: ExemplaireHttpService) { }

  ngOnInit(): void {
  }

  listExemplaires(): Array<Exemplaire> {
    return this.exemplaireService.findAll();
  }

  listCartes(): Array<Carte> {
    return this.exemplaireService.findAllCartes();
  }

  add() {
    this.formExemplaire = new Exemplaire();
    this.valueCarte = new Carte();
    //this.formExemplaire.achats = new Array<Achat>();
  }

  edit(id: number) {
    this.exemplaireService.findById(id).subscribe(resp => {
      this.formExemplaire = resp;
      this.valueCarte = this.formExemplaire.carte;
     // this.user = this.formExemplaire.user;
      //this.achats = this.formExemplaire.achats;

    });
  }

  save() {
    this.formExemplaire.carte = this.valueCarte;
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
