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
	
	
//	@Query("select e from Exemplaire e where e.carte_id = :id_carte")
//	public Optional <Exemplaire> findByExemplaireWithCarte(@Param("carte") Carte carte);
	
	public List<Exemplaire> findByEtat(Etat etat);
	
	public List<Exemplaire> findByValeurExemplaire(Integer prix);

	
	public List<Exemplaire> findByEnVente(boolean enVente);
	
	
//	public List<Exemplaire> findByEnVenteAndUser(boolean enVente);
	
}
