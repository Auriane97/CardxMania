package cardxMania.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cardxMania.model.Lot;
import cardxMania.model.User;

public interface IDAOLot extends JpaRepository<Lot,Integer>{

	@Query("select l from Lot l left join fetch l.achat where l.acheteur=:acheteur")
	public List<Lot> findByAcheteurWithAchat(@Param("acheteur") User acheteur );
	
	@Query("select l from Lot l left join fetch l.achat where l.vendeur=:vendeur")
	public List<Lot> findByVendeurWithAchat(@Param("vendeur") User vendeur );
	
	
}
