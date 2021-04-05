package fr.papounworld.apiGestionUtilisateurs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.papounworld.apiGestionUtilisateurs.model.ConnexionUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;

@RestController
public class ConnexionUtilisateurController {

	@Autowired
	private ConnexionUtilisateurService connexionUtilisateurService;

	@GetMapping("/connexionUtilisateur")
	public Iterable<ConnexionUtilisateur> getConnexionUtilisateurs() {
		return connexionUtilisateurService.getConnexionUtilisateurs();
	}

	@GetMapping("/connexionUtilisateur/{id}")
	public ConnexionUtilisateur getConnexionUtilisateur(@PathVariable("id") final Long id) {
		Optional<ConnexionUtilisateur> connexionUtilisateur = connexionUtilisateurService.getConnexionUtilisateur(id);
		if (connexionUtilisateur.isPresent()) {
			return connexionUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/connexionUtilisateur")
	public ConnexionUtilisateur createConnexionUtilisateur(@RequestBody ConnexionUtilisateur connexionUtilisateur) {
		return connexionUtilisateurService.saveConnexionUtilisateur(connexionUtilisateur);
	}

	@PutMapping("/connexionUtilisateur/{id}")
	public ConnexionUtilisateur updateConnexionUtilisateur(@PathVariable("id") final Long id,
			@RequestBody ConnexionUtilisateur connexionUtilisateurBody) {

		Optional<ConnexionUtilisateur> optionalConnexionUtilisateurUrl = connexionUtilisateurService
				.getConnexionUtilisateur(id);
		if (optionalConnexionUtilisateurUrl.isPresent()) {
			ConnexionUtilisateur connexionUtilisateurUrl = optionalConnexionUtilisateurUrl.get();
			if (connexionUtilisateurBody.getUtilisateur() != null) {
				connexionUtilisateurUrl.setUtilisateur(connexionUtilisateurBody.getUtilisateur());
			}

			if (connexionUtilisateurBody.getConnexionDate() != null) {
				connexionUtilisateurUrl.setConnexionDate(connexionUtilisateurBody.getConnexionDate());
			}

			connexionUtilisateurService.saveConnexionUtilisateur(connexionUtilisateurUrl);
			return connexionUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/connexionUtilisateur/{id}")
	public void deleteConnexionUtilisateur(@PathVariable("id") final Long id) {
		connexionUtilisateurService.deleteConnexionUtilisateur(id);
	}

}
