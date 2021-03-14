package fr.papounworld.apiGestionUtilisateurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.UtilisateurRepository;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@SpringBootApplication
public class ApiGestionUtilisateursApplication implements CommandLineRunner {
	
	@Autowired
	public UtilisateurService utilisateurService;

	public static void main(String[] args) {
		SpringApplication.run(ApiGestionUtilisateursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setLogin("npapon");
		utilisateur.setMotdepasse("Patapoun123");
		utilisateur.setEmail("npapon@live.fr");
		utilisateur.setPrenom("Nicolas");
		utilisateur.setNom("Papon");
		
		utilisateurService.saveUtilisateur(utilisateur);
		
	}

}
