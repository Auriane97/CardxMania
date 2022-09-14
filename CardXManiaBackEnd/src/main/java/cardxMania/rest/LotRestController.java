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

import cardxMania.exception.LotException;
import cardxMania.model.Achat;
import cardxMania.model.Carte;
import cardxMania.model.Lot;
import cardxMania.model.User;
import cardxMania.model.Views;
import cardxMania.service.LotService;


@RestController
@RequestMapping("api/lot")
public class LotRestController {
	
	@Autowired
	private LotService lotService;

	@JsonView(Views.ViewLot.class)
	@GetMapping("")
	public List<Lot> getAll() {
		return lotService.getAll();
	}

	
	@JsonView(Views.ViewLot.class)
	@GetMapping("/{id}")
	public Lot getById(@PathVariable Integer id) {
		Optional<Lot> optLot = lotService.getById(id);
		if(optLot.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le lot n'a pas été trouvé.");
		}
		
		return optLot.get();
	}


	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.ViewLot.class)
	public Lot create(@RequestBody  @Valid Lot lot, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le lot n'a pu être créée.");
		}
		lot = lotService.create(lot);
		
		return lot;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLot.class)
	public Lot update(@PathVariable Integer id, @RequestBody Lot lot) {
		try {
			lotService.getById(id);
		} catch (LotException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return lotService.update(lot);
	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		lotService.deleteById(id);
	}

	
//	@JsonView(Views.ViewLotWithUser.class)
//	@GetMapping("/acheteur")
//	public List<Lot> getByAcheteurWithAchat(@PathVariable User acheteur ){
//			
//		return lotService.findByAcheteurWithAchat(acheteur);
//	}
//	
//	@JsonView(Views.ViewLotWithUser.class)
//	@GetMapping("/vendeur")
//	public List<Lot> getByVendeurWithAchat(@PathVariable User vendeur ){
//			
//		return lotService.findByVendeurWithAchat(vendeur);
//	}
}



