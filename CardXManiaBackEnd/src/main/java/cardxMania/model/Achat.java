package cardxMania.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@ManyToOne
	@JsonView(Views.ViewAchatWithExemplaire.class)
	private Exemplaire exemplaire;
	

	@ManyToOne
	@JsonView(Views.ViewAchatWithLot.class)
	private Lot lot;
	

	public Achat() {}


	public Achat(Exemplaire exemplaire, Lot lot) {
		super();
		this.exemplaire = exemplaire;
		this.lot = lot;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Lot getLot() {
		return lot;
	}


	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}



	@Override
	public String toString() {
		return "Achat [Id=" + id + ", lot=" + lot + "]";
	}


	
	



}
