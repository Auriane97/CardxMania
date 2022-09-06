package cardxMania.CardxMania;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cardxMania.config.AppConfig;
import cardxMania.model.Compte;
import cardxMania.model.User;
import cardxMania.service.AchatService;
import cardxMania.service.CarteService;
import cardxMania.service.CompteService;
import cardxMania.service.ExemplaireService;
import cardxMania.service.LotService;
import cardxMania.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
public class UpdateTest {
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	CarteService carteService;
	
	@Autowired 
	UserService userService;
	
	@Autowired 
	ExemplaireService exemplaireService;
	
	@Autowired
	LotService lotService;

	@Autowired 
	AchatService achatService;
	
	@Test
	public void compteUpdate() {
		Compte	c1 = compteService.create(new User ("Hanz","mdp123","hanz.dong@mail.fr"));
		compteService.update(c1);
		
	}
	
	

}
