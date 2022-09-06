package cardxMania.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cardxMania.dao.IDAOLot;
import cardxMania.exception.LotException;
import cardxMania.model.Lot;


	@Service
	public class LotService {

		
		@Autowired
		private IDAOLot lotRepo;
		
		public List<Lot> getAll() {
			return lotRepo.findAll();
		}
		
		public Optional<Lot> getById(Integer id) {
			return lotRepo.findById(id);
		}
		
		public Lot update(Lot lot) {
			
			
			return lotRepo.save(lot);
		}

		public Lot create(Lot lot) {
			return lotRepo.save(lot);
		}

		public void deleteById(Integer id) {
			lotRepo.deleteById(id);
		}

		
}
