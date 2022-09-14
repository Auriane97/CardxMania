package cardxMania.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cardxMania.model.Carte;
import cardxMania.model.Compte;
import cardxMania.model.Etat;
import cardxMania.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire,Integer> {
	
	
	public List <Exemplaire> findByUser(Compte user);


	public List <Exemplaire> findWithCarteById(Integer id);
	
	
	@Query("select e from Exemplaire e where e.carte.id = :id_carte")
	public List <Exemplaire> findByExemplaireWithCarte(@Param("id_carte") Integer idCarte);
	
	@Query("select e from Exemplaire e where e.etat = :etat")
	public List<Exemplaire> findByEtat(@Param("etat")Etat etat);
	
	public List<Exemplaire> findByValeurExemplaire(Integer prix);

	
	public List<Exemplaire> findByEnVente(boolean enVente);
	
	
//	public List<Exemplaire> findByEnVenteAndUser(boolean enVente);
	
}
