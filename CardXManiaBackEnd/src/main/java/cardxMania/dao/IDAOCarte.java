package cardxMania.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import cardxMania.model.Carte;
import cardxMania.model.Serie;


public interface IDAOCarte extends JpaRepository<Carte,Integer>{
	
	@Query("select c from Carte c where c.serie = :serie")
	public List<Carte> findByCarteWithSerie(@Param("serie") Serie libelle);
	
//	@RestResource(path = "/by-libelle-containing")
//	public List<Carte> findByLibelleContaining(String lib);

	
	

//	@Query("select c from Carte c left join fetch c.compte where c.id=:id")
//	Optional<Carte> findByIdWithCompte(@Param("id") Integer id);
	
//	@Query("select c from Carte c left join fetch c.dateAchat where c.dateAchat=: ")
//	public void findByDate



}
