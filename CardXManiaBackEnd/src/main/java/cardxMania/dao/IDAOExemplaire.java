package cardxMania.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cardxMania.model.Carte;
import cardxMania.model.Compte;
import cardxMania.model.Etat;
import cardxMania.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire,Integer> {
	
	
	public List <Exemplaire> findByUser(Compte user);

	
	public List <Exemplaire> findByCarte(Carte carte);
	
	public List<Exemplaire> findByEtat(Etat etat);
	
	public List<Exemplaire> findByValeurExemplaire(Integer prix);

	
	public List<Exemplaire> findByEnVente(boolean enVente);
	
	public List<Exemplaire> findByEnVenteAndUser(boolean enVente);
	
}
