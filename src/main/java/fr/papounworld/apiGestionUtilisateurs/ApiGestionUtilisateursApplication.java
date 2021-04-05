package fr.papounworld.apiGestionUtilisateurs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.papounworld.apiGestionUtilisateurs.model.ConnexionUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.model.InformationPersonnelleUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.InformationPersonnelleUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.RoleService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@SpringBootApplication
public class ApiGestionUtilisateursApplication implements CommandLineRunner {

	@Autowired
	public UtilisateurService utilisateurService;

	@Autowired
	public InformationPersonnelleUtilisateurService informationsPersonnellesUtilisateurService;

	@Autowired
	public RoleService roleService;

	@Autowired
	public ConnexionUtilisateurService connexionsUtilisateurService;

	public static void main(String[] args) {
		SpringApplication.run(ApiGestionUtilisateursApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Utilisateur> utilisateurOptional = utilisateurService.getUtilisateur((long) 1);

		Optional<InformationPersonnelleUtilisateur> informationsPersonnellesUtilisateurOptional = informationsPersonnellesUtilisateurService
				.getInformationPersonnellesUtilisateur((long) 1);

		InformationPersonnelleUtilisateur informationsPersonnellesUtilisateur = informationsPersonnellesUtilisateurOptional
				.get();

		Utilisateur utilisateur = utilisateurOptional.get();
		Optional<ConnexionUtilisateur> connectionsUtilisateurOptional = connexionsUtilisateurService
				.getConnexionUtilisateur(1L);

		System.out.println("Objet utilisateur " + utilisateur);
		System.out.println("Objet information personnelle " + informationsPersonnellesUtilisateur);
		System.out.println(connectionsUtilisateurOptional.get().getConnexionDate());
//System.out.println(utilisateur.getInformationsPersonnellesUtilisateur());

	}

}
