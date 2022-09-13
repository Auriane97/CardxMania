package cardxMania.rest;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import cardxMania.dao.IDAOCarte;
import cardxMania.exception.CarteException;
import cardxMania.model.Achat;
import cardxMania.model.Carte;
import cardxMania.model.Serie;
import cardxMania.model.Views;
import cardxMania.model.Views.ViewCarteWithSerie;
import cardxMania.service.CarteService;






@RestController
@RequestMapping("/api/carte")
public class CarteRestCOntroller {
	
	@Autowired
	private CarteService carteService;
	@Autowired
	private IDAOCarte carteRepo;

	@JsonView(Views.ViewCarte.class)
	@GetMapping("")
	public List<Carte> getAll() {
		return carteService.findAll();
	}

	@JsonView(Views.ViewCarte.class)
	@GetMapping("/{id}")
	public Carte getById(@PathVariable Integer id) {
		Optional<Carte> optCarte = carteService.getById(id);
		if(optCarte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La carte n'a pas été trouvée.");
		}
		
		return optCarte.get();
	}

	

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.ViewCarte.class)
	public Carte create(@RequestBody Carte carte) {
		return carteService.create(carte);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCarte.class)
	public Carte update(@PathVariable Integer id, @RequestBody Carte carte) {
		try {
			carteService.getById(id);
		} catch (CarteException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return carteService.update(carte);
	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		carteService.deleteById(id);
	}
	
	@JsonView(Views.ViewCarteWithSerie.class)
	@GetMapping("/serie")
	public Optional<Carte> getByCarteWithSerie(@PathVariable Serie serie){
			
		return carteService.getByCarteWithSerie(serie);
	}
	
	@GetMapping("/by-libelle/{libelle}")
	@JsonView(Views.ViewCarte.class)
	public List<Carte> findAllByLibelle(@PathVariable String lib) {
		return carteRepo.findByLibelleContaining(lib);
	}
	

}
