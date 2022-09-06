package cardxMania.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cardxMania.model.Carte;
import cardxMania.model.Serie;

public interface IDAOCarte extends JpaRepository<Carte,Integer>{
	
	
	public List <Carte> findBySerie(Serie serie);
	
	

}
