package cardxMania.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cardxMania.dao.IDAOCompte;
import cardxMania.exception.CompteException;
import cardxMania.model.User;

@Service
public class UserService {

	

	@Autowired
	private IDAOCompte compteRepo;
	
	public
	

	public User getById(Integer id) {
		return (User) compteRepo.findById(id).orElseThrow(CompteException::new);
	}

	public User create(User user) {
		return compteRepo.save(user);
	}

	public User update(User user) {
		return compteRepo.save(user);
	}

	public void deleteById(Integer id) {
		compteRepo.deleteById(id);
	}
	
	
}
