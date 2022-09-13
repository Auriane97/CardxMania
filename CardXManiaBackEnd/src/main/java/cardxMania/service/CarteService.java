package cardxMania.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cardxMania.dao.IDAOCarte;
import cardxMania.exception.CarteException;
import cardxMania.model.Carte;
import cardxMania.model.Serie;


@Service
public class CarteService {
	
	@Autowired
	private IDAOCarte carteRepo;
	
	public List<Carte> findAll() {
		return carteRepo.findAll();
	}
	
	public Optional<Carte> getById(Integer id) {
		return carteRepo.findById(id);
	}

	public Carte create(Carte carte) {
		return carteRepo.save(carte);
	}

	public Carte update(Carte carte) {
		return carteRepo.save(carte);
	}

	public void deleteById(Integer id) {
		carteRepo.deleteById(id);
	}

	public Optional<Carte> getByCarteWithSerie(Serie serie) {
		return carteRepo.findByCarteWithSerie(serie);
		
	}
	

}
