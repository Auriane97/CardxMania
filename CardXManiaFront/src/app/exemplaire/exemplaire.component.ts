import { Component, OnInit } from '@angular/core';
import { Exemplaire } from 'src/model';
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
    this.formExemplaire.
  }

  edit(id: number) {
    this.exemplaireService.findById(id).subscribe(resp => {
      this.formExemplaire = resp;

      if(!this.formExemplaire.adresse) {
        this.formExemplaire.adresse = new Adresse();
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
