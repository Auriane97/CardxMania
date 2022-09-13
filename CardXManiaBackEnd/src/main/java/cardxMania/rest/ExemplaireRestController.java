package cardxMania.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import cardxMania.exception.ExemplaireException;
import cardxMania.model.Achat;
import cardxMania.model.Carte;
import cardxMania.model.Etat;
import cardxMania.model.Exemplaire;
import cardxMania.model.User;
import cardxMania.model.Views;
import cardxMania.service.ExemplaireService;


@RestController
@RequestMapping("api/exemplaire")
public class ExemplaireRestController {

	
	@Autowired
	private ExemplaireService exemplaireService;

	@JsonView(Views.ViewExemplaire.class)
	@GetMapping("")
	public List<Exemplaire> getAll() {
		return exemplaireService.getAll();
	}

	@JsonView(Views.ViewExemplaire.class)
	@GetMapping("/{id}")
	public Exemplaire getById(@PathVariable Integer id) {
		Optional<Exemplaire> optExemplaire = exemplaireService.getById(id);

		if(optExemplaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'exempalire n'a pas été trouvé.");
		}
		
		return optExemplaire.get();
	}


	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.ViewExemplaire.class)
	public Exemplaire create(@RequestBody Exemplaire exemplaire, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'exempalire n'a pu être créée.");
		}
		exemplaire = exemplaireService.create(exemplaire);
		
		return exemplaire;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewExemplaire.class)
	public Exemplaire update(@PathVariable Integer id, @RequestBody Exemplaire exemplaire) {
		try {
			exemplaireService.getById(id);
		} catch (ExemplaireException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return exemplaireService.update(exemplaire);
	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		exemplaireService.deleteById(id);
	}
	
	@GetMapping("/carte")
	@JsonView(Views.ViewExemplaireWithCarte.class)
	public List<Exemplaire> getByCarte(@PathVariable Carte carte) {
		List <Exemplaire> carteExemplaire = exemplaireService.getByCarte(carte);
		
		return carteExemplaire;
	
	}

	@GetMapping("/vendeur")
	@JsonView(Views.ViewExemplaireWithUser.class)
	public List<Exemplaire> getByVendeur(@PathVariable User vendeur) {
		List<Exemplaire> vendeurExemplaire = exemplaireService.getByVendeur(vendeur);
		
		return vendeurExemplaire;
	
	}
	
	@GetMapping("/etat")
	@JsonView(Views.ViewExemplaire.class)
	public List<Exemplaire> getByEtat(@PathVariable Etat etat) {
		List<Exemplaire> etatExemplaire = exemplaireService.getByEtat(etat);
		
		return etatExemplaire;
		
	}
	
	@GetMapping("/valeur-exempplaire")
	@JsonView(Views.ViewExemplaire.class)
	public List<Exemplaire> getByValeurExemplaire(@PathVariable Integer valeurExemplaire) {
		List<Exemplaire> valExemplaire = exemplaireService.getByValeurExemplaire(valeurExemplaire);
		return valExemplaire;
	
	}
	
	@GetMapping("/en-vente")
	@JsonView(Views.ViewExemplaire.class)
	public List<Exemplaire> getByEnVente(@PathVariable boolean enVente) {
		List<Exemplaire> enVenteExemplaire = exemplaireService.getByEnVente(enVente);

		return enVenteExemplaire;
	}
}
