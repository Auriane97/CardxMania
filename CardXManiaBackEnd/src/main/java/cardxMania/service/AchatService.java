package cardxMania.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cardxMania.dao.IDAOAchat;
import cardxMania.exception.AchatException;
import cardxMania.model.Achat;



@Service
public class AchatService {

	@Autowired
	private IDAOAchat achatRepo;
	
	
//	public Achat getById(Integer id) {
//		return achatRepo.findById(id).orElseThrow(() -> {
//			throw new AchatException("id inconnu"); 
//			});
//	}
	
	public Optional<Achat> getById(Integer id) {
		return achatRepo.findById(id);
	}
	
	
	public List<Achat> getAll() {
		return achatRepo.findAll();
	}
	
	public Achat create(Achat achat) {
		return achatRepo.save(achat);
	}

	public Achat update(Achat achat) {
		return achatRepo.save(achat);
	}
	
	public void delete(Achat achat) {
		//achatRepo.setNullToAchatByAchat(achat);
		achatRepo.delete(achat);
	}
	
	public void deleteById(Integer id) {
		achatRepo.deleteById(id);
	}

}
