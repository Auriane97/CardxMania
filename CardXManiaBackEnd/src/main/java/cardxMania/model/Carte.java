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



@Entity
public class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected int cote;
	
	@Lob
	private transient byte[] photo;
	
	private String description;
	
	@OneToMany(mappedBy="carte")
	private List<Exemplaire> exemplaires;
	
	@Enumerated(EnumType.STRING)
	private Serie serie;
	
	
	public Carte() {}

	public Carte(int cote, String description, Serie serie) {
		this.cote = cote;
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
		return "Carte [cote=" + cote + ", description=" + description + ", serie=" + serie + "]";
	}
	
	
	
	
}
