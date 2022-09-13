package cardxMania.CardxMania;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cardxMania.model.Achat;
import cardxMania.model.Etat;
import cardxMania.model.Exemplaire;
import cardxMania.service.AchatService;
import cardxMania.service.CarteService;
import cardxMania.service.CompteService;
import cardxMania.service.ExemplaireService;
import cardxMania.service.LotService;
import cardxMania.service.UserService;

@SpringBootTest
public class SuiteTest {
	
	private final CompteService compteService;
	private final CarteService carteService;
	private final UserService userService;
	private final LotService lotService;
	private ExemplaireService exemplaireService;
	private AchatService achatService;
	
	@Autowired
	public SuiteTest(CompteService compteService,CarteService carteService,
			UserService userService, LotService lotService, ExemplaireService exemplaireService, AchatService achatService) {
		this.compteService = compteService;
		this.carteService = carteService;
		this.userService = userService;
		this.lotService = lotService;
		this.exemplaireService = exemplaireService;
		this.achatService = achatService;
	}
		
	
	@Test
	public void exemplaireCreation() {

		exemplaireService.create(new Exemplaire(true,carteService.getById(3).get(),Etat.Abimee,compteService.getById(3).get()));
		exemplaireService.create(new Exemplaire(true,carteService.getById(2).get(),Etat.BonEtat,compteService.getById(4).get()));
		exemplaireService.create(new Exemplaire(false,carteService.getById(1).get(),Etat.Abimee,compteService.getById(1).get()));
		exemplaireService.create(new Exemplaire(true,carteService.getById(4).get(),Etat.BonEtat,compteService.getById(4).get()));
	}
	
	@Test
	public void achatCreation() {
		achatService.create(new Achat(exemplaireService.getById(2).get(), lotService.getById(1).get()));
		achatService.create(new Achat(exemplaireService.getById(3).get(), lotService.getById(1).get()));
		achatService.create(new Achat(exemplaireService.getById(4).get(), lotService.getById(2).get()));
	}
	

}
