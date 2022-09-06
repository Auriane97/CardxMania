package cardxMania.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("User")
public class User extends Compte {

	public User() {
		}
	
	
	public User(String pseudo, String password, String mail) {
		super(pseudo, password, mail);
	}

	public User(String pseudo, String password) {
		super(pseudo,password);
	}


	@Override
	public String toString() {
		return "User [mail=" + mail + ", id=" + id + ", total=" + total + ", pseudo=" + pseudo + ", password="
				+ password + "]";
	}
	
	
}
