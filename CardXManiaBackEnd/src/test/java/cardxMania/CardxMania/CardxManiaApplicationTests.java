package cardxMania.CardxMania;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import cardxMania.model.Achat;
import cardxMania.model.Admin;
import cardxMania.model.Carte;
import cardxMania.model.Etat;
import cardxMania.model.Exemplaire;
import cardxMania.model.Lot;
import cardxMania.model.Serie;
import cardxMania.model.User;
import cardxMania.service.AchatService;
import cardxMania.service.CarteService;
import cardxMania.service.CompteService;
import cardxMania.service.ExemplaireService;
import cardxMania.service.LotService;
import cardxMania.service.UserService;

@SpringBootTest
class CardxManiaApplicationTests {

	private final CompteService compteService;
	private final CarteService carteService;
	private final UserService userService;
	private final LotService lotService;
	private ExemplaireService exemplaireService;
	private AchatService achatService;
	
	@Autowired
	public CardxManiaApplicationTests(CompteService compteService,CarteService carteService,
			UserService userService, LotService lotService, ExemplaireService exemplaireService, AchatService achatService) {
		this.compteService = compteService;
		this.carteService = carteService;
		this.userService = userService;
		this.lotService = lotService;
		this.exemplaireService = exemplaireService;
		this.achatService = achatService;
			

	}
	
	@Test
	public void compteCreation() {
		compteService.create(new User ("Hanz","mdp123","hanz.dong@mail.fr"));
		compteService.create(new User("John","Dov","JDoe@mail.fr"));
		compteService.create(new User("Jack","Don","JackDoe@mail.fr"));
		compteService.create(new User("Jessie","Din12","JessieDoe@mail.fr"));
		compteService.create(new User("Jason","De66","JasonDoe@mail.fr"));
		compteService.create(new Admin("Jordan","ABID"));
	}

	@Test
	public void carteCreation() {
		carteService.create(new Carte(10,"Magic", "Je suis la première carte test Magic.", Serie.Magic));
		carteService.create(new Carte(20,"Panini", "Je suis la première carte test Panini.", Serie.Panini));
		carteService.create(new Carte(50,"Pokemon", "Je suis la première carte test Pokemon.", Serie.Pokemon));
		carteService.create(new Carte(5,"yugi-oh", "Je suis la première carte test Yugioh.", Serie.Yugioh));
	}
	

	@Test
	public void lotCreation() {
		lotService.create(new Lot(userService.getById(3),userService.getById(4),LocalDate.now()));
		lotService.create(new Lot(userService.getById(4),userService.getById(5),LocalDate.now()));
	}
	
//	@Test
//	public void exemplaireCreation() {
//
//		exemplaireService.create(new Exemplaire(true,carteService.getById(3).get(),Etat.Abimee,compteService.getById(3).get()));
//		exemplaireService.create(new Exemplaire(true,carteService.getById(2),Etat.BonEtat,compteService.getById(4)));
//		exemplaireService.create(new Exemplaire(false,carteService.getById(1),Etat.Abimee,compteService.getById(1)));
//		exemplaireService.create(new Exemplaire(true,carteService.getById(4),Etat.BonEtat,compteService.getById(4)));
//	}
//	
//	@Test
//	public void achatCreation() {
//		achatService.create(new Achat(exemplaireService.getById(2), lotService.getById(1)));
//		achatService.create(new Achat(exemplaireService.getById(3), lotService.getById(1)));
//		achatService.create(new Achat(exemplaireService.getById(4), lotService.getById(2)));
//	}
}
