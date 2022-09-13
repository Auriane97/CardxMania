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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import cardxMania.exception.AchatException;
import cardxMania.model.Achat;
import cardxMania.model.Views;
import cardxMania.service.AchatService;


@RestController
@RequestMapping("/api/achat")
public class AchatRestController {
	
	
	@Autowired
	private AchatService achatService;

	@JsonView(Views.ViewAchat.class)
	@GetMapping("")
	public List<Achat> getAll() {
		return achatService.getAll();
	}

	@JsonView(Views.ViewAchat.class)
	@GetMapping("/{id}")
	public Achat getById(@PathVariable Integer id) {
		Optional<Achat> optAchat = achatService.getById(id);

		if(optAchat.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'achat n'a pas été trouvé.");
		}
		
		return optAchat.get();
	}


	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.ViewAchat.class)
	public Achat create(@RequestBody  @Valid Achat achat, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'achat n'a pu être créée.");
		}
		achat = achatService.create(achat);
		
		return achat;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAchat.class)
	public Achat update(@RequestBody Achat achat, @PathVariable Integer id) {
		try {
			achatService.getById(id);
		} catch (AchatException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		achat = achatService.update(achat);

		return achat;	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		achatService.deleteById(id);
	}
	

}
