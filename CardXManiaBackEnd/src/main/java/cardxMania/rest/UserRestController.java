package cardxMania.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import cardxMania.exception.UserException;
import cardxMania.model.Compte;
import cardxMania.model.User;
import cardxMania.model.Views;
import cardxMania.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@JsonView(Views.ViewUser.class)
	@GetMapping("")
	public List<Compte> getAll() {
		return userService.getAll();
	}

	@JsonView(Views.ViewLot.class)
	@GetMapping("/{id}")
	public User getById(@PathVariable Integer id) {
		return userService.getById(id);
	}



	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.ViewLot.class)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	
	@PutMapping("/{id}")
	@JsonView(Views.ViewLot.class)
	public User update(@PathVariable Integer id, @RequestBody User user) {
		try {
			userService.getById(id);
		} catch (UserException ex) {//class user exeption a creer
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return userService.update(user);
	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		userService.deleteById(id);
	}
	


}
