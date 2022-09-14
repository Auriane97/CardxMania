package cardxMania.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cardxMania.dao.IDAOCompte;
import cardxMania.model.Compte;

@Service
public class CompteService {

	

	@Autowired
	private IDAOCompte compteRepo;
	

	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

	public Optional<Compte> getById(Integer id) {
		return compteRepo.findById(id);
	}

	public Compte create(Compte compte) {
		return compteRepo.save(compte);
	}

	public Compte update(Compte compte) {
		return compteRepo.save(compte);
	}

	public void deleteById(Integer id) {
		compteRepo.deleteById(id);
	}
	
	public Optional<Compte> getByPseudo (String pseudo){
		return compteRepo.findByPseudo(pseudo);
	}
	
	public  Optional<Compte> seConnecter(String pseudo,String password) {
		return compteRepo.findByPseudoAndPassword(pseudo, password);
	}
	
	
}
