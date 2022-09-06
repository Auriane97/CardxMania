package cardxMania.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Exemplaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy="exemplaire")
	private List<Achat> achats;
	
	@ManyToOne
	private Compte user;
	
	@Column(name="en_vente")
	private boolean enVente;
	
	@Column(name="valeur_exemplaire")
	private Integer valeurExemplaire;
	
	@ManyToOne
	private Carte carte;
	

	@Column(name = "etat", nullable = false, columnDefinition = "ENUM('Abimee','BonEtat','Neuf')")
	@Enumerated(EnumType.STRING)
	private Etat etat;
	

	public Exemplaire() {}
	
	public Exemplaire(boolean enVente, Carte carte, Etat etat,Compte user) {
		
		this.enVente = enVente;
		this.valeurExemplaire = carte.getCote()*etat.getValeur();
		this.carte = carte;
		this.etat = etat;
		this.user=user;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Compte getUser() {
		return user;
	}

	public void setUser(Compte user) {
		this.user = user;
	}

	public boolean isEnVente() {
		return enVente;
	}


	public Integer getValeurExemplaire() {
		return valeurExemplaire;
	}


	public Carte getCarte() {
		return carte;
	}


	public Etat getEtat() {
		return etat;
	}


	public void setEnVente(boolean enVente) {
		this.enVente = enVente;
	}


	public void setValeurExemplaire(Integer valeurExemplaire) {
		this.valeurExemplaire = valeurExemplaire;
	}


	public void setCarte(Carte carte) {
		this.carte = carte;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Exemplaire [enVente=" + enVente + ", valeurExemplaire=" + valeurExemplaire + ", carte=" + carte
				+ ", etat=" + "etat ]";
	}
	
	
	
	
	
}
