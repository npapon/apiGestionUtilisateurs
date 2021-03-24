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

import fr.papounworld.apiGestionUtilisateurs.model.ConnexionsUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionsUtilisateurService;

@RestController
public class ConnexionsUtilisateurController {

	@Autowired
	private ConnexionsUtilisateurService connexionsUtilisateurService;

	@GetMapping("/connexionsUtilisateurs")
	public Iterable<ConnexionsUtilisateur> getConnexionsUtilisateurs() {
		return connexionsUtilisateurService.getConnexionsUtilisateurs();
	}

	@GetMapping("/connexionsUtilisateur/{id}")
	public ConnexionsUtilisateur getConnexionsUtilisateur(@PathVariable("id") final Long id) {
		Optional<ConnexionsUtilisateur> connexionsUtilisateur = connexionsUtilisateurService
				.getConnexionsUtilisateur(id);
		if (connexionsUtilisateur.isPresent()) {
			return connexionsUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/connexionsUtilisateur")
	public ConnexionsUtilisateur createConnexionsUtilisateur(@RequestBody ConnexionsUtilisateur connexionsUtilisateur) {
		return connexionsUtilisateurService.saveConnexionsUtilisateur(connexionsUtilisateur);
	}

	@PutMapping("/connexionsUtilisateur/{id}")
	public ConnexionsUtilisateur updateConnexionsUtilisateur(@PathVariable("id") final Long id,
			@RequestBody ConnexionsUtilisateur connexionsUtilisateurBody) {

		Optional<ConnexionsUtilisateur> optionalConnexionsUtilisateurUrl = connexionsUtilisateurService
				.getConnexionsUtilisateur(id);
		if (optionalConnexionsUtilisateurUrl.isPresent()) {
			ConnexionsUtilisateur connexionsUtilisateurUrl = optionalConnexionsUtilisateurUrl.get();
			if (connexionsUtilisateurBody.getUtilisateur() != null) {
				connexionsUtilisateurUrl.setUtilisateur(connexionsUtilisateurBody.getUtilisateur());
			}

			if (connexionsUtilisateurBody.getConnexionDate() != null) {
				connexionsUtilisateurUrl.setConnexionDate(connexionsUtilisateurBody.getConnexionDate());
			}

			connexionsUtilisateurService.saveConnexionsUtilisateur(connexionsUtilisateurUrl);
			return connexionsUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/connexionsUtilisateur/{id}")
	public void deleteConnexionsUtilisateur(@PathVariable("id") final Long id) {
		connexionsUtilisateurService.deleteConnexionsUtilisateur(id);
	}

}
