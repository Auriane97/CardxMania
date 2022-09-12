package cardxMania.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Lot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@OneToMany(mappedBy = "lot")
	@JsonView(Views.ViewAchat.class)
	private List<Achat> achats;
	
	@JsonView(Views.ViewBase.class)
	private int note;

	@ManyToOne
	@JsonView(Views.ViewUser.class)
	private User acheteur;
	
	@ManyToOne
	@JsonView(Views.ViewUser.class)
	private User vendeur;
	
	
	@Column(name="date_achat")
	@JsonView(Views.ViewBase.class)
	private LocalDate dateAchat;

	
	
	public Lot() {
	}

	
	public Lot(User acheteur, User vendeur, LocalDate dateAchat) {
		super();
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		this.dateAchat = dateAchat;
	}



	public LocalDate getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}


	public int getNote() {
		return note;
	}

	

	public void setNote(int note) {
		this.note = note;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public List<Achat> getAchats() {
		return achats;
	}


	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}


	public User getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(User acheteur) {
		this.acheteur = acheteur;
	}

	public User getVendeur() {
		return vendeur;
	}

	public void setVendeur(User vendeur) {
		this.vendeur = vendeur;
	}

	@Override
	public String toString() {
		return "Lot [note=" + note + ", acheteur=" + acheteur + ", vendeur=" + vendeur + ", dateAchat=" + dateAchat
				+ "]";
	}

	

}
