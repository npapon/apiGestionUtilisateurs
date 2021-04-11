package fr.papounworld.apiGestionUtilisateurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;

@SpringBootApplication
public class ApiGestionUtilisateursApplication implements CommandLineRunner {

	@Autowired
	public ActionApplicativeService actionApplicativeService;

	public static void main(String[] args) {
		SpringApplication.run(ApiGestionUtilisateursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * ActionApplicativeScript actionApplicative = new ActionApplicativeScript();
		 * actionApplicative.setLibelle("doublon écritures");
		 * actionApplicative.setCrud("read");
		 * actionApplicativeService.saveActionApplicative(actionApplicative);
		 */

	}

}
