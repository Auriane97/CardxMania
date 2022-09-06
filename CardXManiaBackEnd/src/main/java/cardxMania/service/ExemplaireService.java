package cardxMania.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cardxMania.dao.IDAOExemplaire;
import cardxMania.exception.ExemplaireException;
import cardxMania.model.Carte;
import cardxMania.model.Etat;
import cardxMania.model.Exemplaire;
import cardxMania.model.User;



	@Service
	public class ExemplaireService {

		
		@Autowired
		private IDAOExemplaire exemplaireRepo;
		
		

		public List<Exemplaire> getAll() {
			return exemplaireRepo.findAll();
		}
		
		
		public List<Exemplaire> getByCarte(Carte carte) {
			return exemplaireRepo.findByCarte(carte);
		}
		
			
		public Optional<Exemplaire> getById(Integer id) {
			return exemplaireRepo.findById(id);
		}

		public Exemplaire create(Exemplaire exemplaire) {
			return exemplaireRepo.save(exemplaire);
		}

		public Exemplaire update(Exemplaire exemplaire) {
			return exemplaireRepo.save(exemplaire);
		}

		public void deleteById(Integer id) {
			exemplaireRepo.deleteById(id);
		}

		public List<Exemplaire> getByVendeur(User vendeur) {
			return exemplaireRepo.findByUser(vendeur);
		}
		
		public List<Exemplaire> getByEtat(Etat etat) {
			return exemplaireRepo.findByEtat(etat);
			
		}
		
		public List<Exemplaire> getByValeurExemplaire(Integer valeurExemplaire) {
			return exemplaireRepo.findByValeurExemplaire(valeurExemplaire);
		}
		
}
