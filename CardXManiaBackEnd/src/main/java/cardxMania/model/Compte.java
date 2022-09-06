package cardxMania.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte", columnDefinition = "ENUM('Admin','User')")
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	
	protected String pseudo;
	protected String password;
	protected String mail;
	protected transient Integer total;
	
	@OneToMany(mappedBy="user")
	protected List<Exemplaire> exemplaires;
	
	@OneToMany(mappedBy="vendeur")
	protected List<Lot> ventes;
	
	@OneToMany(mappedBy="acheteur")
	protected List<Lot> achats;
	
	
	
	public Compte() {
		
	}
	
	public Compte(String pseudo, String password, String mail) {

		this.pseudo = pseudo;
		this.password = password;
		this.mail=mail;
		
		
	}
	

	public Compte(String pseudo, String password) {
		this.pseudo = pseudo;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	public List<Lot> getVentes() {
		return ventes;
	}

	public void setVentes(List<Lot> ventes) {
		this.ventes = ventes;
	}

	public List<Lot> getAchats() {
		return achats;
	}

	public void setAchats(List<Lot> achats) {
		this.achats = achats;
	}


}
