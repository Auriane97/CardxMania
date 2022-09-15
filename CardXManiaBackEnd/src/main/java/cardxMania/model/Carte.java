package cardxMania.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Carte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	protected Integer id;

	@JsonView(Views.ViewBase.class)
	protected int cote;

	@JsonView(Views.ViewBase.class)
	protected String libelle;

	@JsonView(Views.ViewBase.class)
	protected String imgPath;

	@Lob
	private transient byte[] photo;

	@JsonView(Views.ViewBase.class)
	private String description;

	@OneToMany(mappedBy = "carte")
	@JsonView(Views.ViewCartewithExemplaire.class)
	private List<Exemplaire> exemplaires;

	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewBase.class)
	private Serie serie;

	public Carte() {
	}

	public Carte(int cote, String libelle, String description, Serie serie) {
		super();

		this.cote = cote;
		this.libelle = libelle;
		this.description = description;
		this.serie = serie;
	}

	public int getCote() {
		return cote;
	}

	public String getDescription() {
		return description;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setCote(int cote) {
		this.cote = cote;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer idCarte) {
		this.id = idCarte;
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

//	public byte[] getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}

	public String toString() {
		return "Carte [cote=" + cote + ", description=" + description + ", serie=" + serie + ", libelle=" + libelle
				+ "]";
	}

}
