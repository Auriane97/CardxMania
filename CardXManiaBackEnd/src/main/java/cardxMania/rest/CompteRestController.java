package cardxMania.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import cardxMania.exception.CompteException;
import cardxMania.model.Compte;
import cardxMania.model.Views;
import cardxMania.rest.dto.LoginDTO;
import cardxMania.service.CompteService;



@RestController
@RequestMapping("/api/compte")
@CrossOrigin("*")
public class CompteRestController {
	
	@Autowired
	private CompteService compteService;


	@JsonView(Views.ViewCompte.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return compteService.getAll();
	}

	@JsonView(Views.ViewCompte.class)
	@GetMapping("/{id}")
	public Compte getById(@PathVariable Integer id) {
		Optional<Compte> optCompte = compteService.getById(id);

		if(optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optCompte.get();
	}

	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.ViewCompte.class)
	public Compte create(@RequestBody @Valid Compte compte, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le compte n'a pu être créé");
		}
		compte = compteService.create(compte);
		
		return compte;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte update(@PathVariable Integer id, @RequestBody Compte compte) {
		try {
			compteService.getById(id);
		} catch (CompteException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return compteService.update(compte);
	}

	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		compteService.deleteById(id);
	}
	
	@PostMapping("/login")
	@JsonView(Views.ViewCompte.class)
	public Compte login(@RequestBody LoginDTO loginDTO) {
		Optional<Compte> optionalCompte = compteService.seConnecter(loginDTO.getPseudo(), loginDTO.getPassword());
		
		if(!optionalCompte.isPresent()) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Utilisateur inconnu");
		}
		
		return optionalCompte.get();
	}
	
	
//	@DeleteMapping("/{id}")
//	public void deleteByCompte(@PathVariable String pseudo) {
//		compteRepo.deleteByCompte(pseudo);
//	}

}
