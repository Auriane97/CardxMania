package cardxMania.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte", columnDefinition = "ENUM('Admin','User')")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "role")
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
	@JsonSubTypes.Type(value = User.class, name = "USER") 
})
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	protected Integer id;

	@NotNull
	@Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$")
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	@JsonView(Views.ViewBase.class)
	protected String pseudo;

	@NotNull
	@Size(max = 60)
	@Column(name = "password", length = 60, nullable = false)
	@JsonView(Views.ViewBase.class)
	protected String password;

	@Email
	@Column(length = 254)
	@JsonView(Views.ViewBase.class)
	protected String mail;

	@NotNull
	@Column(nullable = false)
	@JsonView(Views.ViewBase.class)
	private boolean activated = true;

	@JsonView(Views.ViewBase.class)
	protected transient Integer total;

	@OneToMany(mappedBy = "user")
	@JsonView(Views.ViewCompteWithExemplaire.class)
	protected List<Exemplaire> exemplaires;

	@OneToMany(mappedBy = "vendeur")
	@JsonView(Views.ViewCompteWithLot.class)
	protected List<Lot> ventes;

	@OneToMany(mappedBy = "acheteur")
	@JsonView(Views.ViewCompteWithLot.class)
	protected List<Lot> achats;

	

	public Compte() {

	}

	public Compte(
			@NotNull @Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$") @Size(min = 1, max = 50) String pseudo,
			@NotNull @Size(min = 60, max = 60) String password, String mail) {

		this.pseudo = pseudo;
		this.password = password;
		this.mail = mail;

	}

	public Compte(
			@NotNull @Pattern(regexp = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$") @Size(min = 1, max = 50) String pseudo,
			@NotNull @Size(min = 60, max = 60) String password) {

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

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
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
