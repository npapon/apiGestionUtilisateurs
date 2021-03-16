package fr.papounworld.apiGestionUtilisateurs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.papounworld.apiGestionUtilisateurs.model.InformationsPersonnellesUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.UtilisateurRepository;
import fr.papounworld.apiGestionUtilisateurs.service.InformationsPersonnellesUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@SpringBootApplication
public class ApiGestionUtilisateursApplication implements CommandLineRunner {
	
	@Autowired
	public UtilisateurService utilisateurService;
	
	@Autowired
	public InformationsPersonnellesUtilisateurService informationsPersonnellesUtilisateurService;

	public static void main(String[] args) {
		SpringApplication.run(ApiGestionUtilisateursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Optional<Utilisateur> utilisateurOptional = utilisateurService.getUtilisateur((long) 12) ;
		
		Optional<InformationsPersonnellesUtilisateur> informationsPersonnellesUtilisateurOptional = informationsPersonnellesUtilisateurService.getInformationsPersonnellesUtilisateur((long) 1) ;
	
Utilisateur utilisateur = utilisateurOptional.get();

InformationsPersonnellesUtilisateur informationsPersonnellesUtilisateur = informationsPersonnellesUtilisateurOptional.get();
System.out.println(utilisateur);
System.out.println(informationsPersonnellesUtilisateur);
		
	}

}
