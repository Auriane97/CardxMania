package cardxMania.model;


public enum Etat {

	Abimee(1), BonEtat(10), Neuf(100);

	
	private int valeur;
	
	private Etat () {
		
	}
	private Etat(int valeur) {
		this.setValeur(valeur);
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	

}
