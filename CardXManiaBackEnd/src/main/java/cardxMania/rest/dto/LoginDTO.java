package cardxMania.rest.dto;

public class LoginDTO {
	private String pseudo;
	private String password;

	public LoginDTO() {
		super();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
