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

import fr.papounworld.apiGestionUtilisateurs.model.FichierUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.FichierUtilisateurService;

@RestController
public class FichierUtilisateurController {

	@Autowired
	private FichierUtilisateurService fichierUtilisateurService;

	@GetMapping("/fichierutilisateur")
	public Iterable<FichierUtilisateur> getFichierUtilisateurs() {
		return fichierUtilisateurService.getFichierUtilisateurs();
	}

	@GetMapping("/fichierutilisateur/{id}")
	public FichierUtilisateur getFichierUtilisateur(@PathVariable("id") final Long id) {
		Optional<FichierUtilisateur> fichierUtilisateur = fichierUtilisateurService.getFichierUtilisateur(id);
		if (fichierUtilisateur.isPresent()) {
			return fichierUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/fichierutilisateur")
	public FichierUtilisateur createFichierUtilisateur(@RequestBody FichierUtilisateur fichierUtilisateur) {
		return fichierUtilisateurService.saveFichierUtilisateur(fichierUtilisateur);
	}

	@PutMapping("/fichierutilisateur/{id}")
	public FichierUtilisateur updateFichierUtilisateur(@PathVariable("id") final Long id,
			@RequestBody FichierUtilisateur fichierUtilisateurBody) {

		Optional<FichierUtilisateur> optionalFichierUtilisateurUrl = fichierUtilisateurService
				.getFichierUtilisateur(id);
		if (optionalFichierUtilisateurUrl.isPresent()) {
			FichierUtilisateur fichierUtilisateurUrl = optionalFichierUtilisateurUrl.get();

			if (fichierUtilisateurBody.getIdUtilisateur() != 0) {
				fichierUtilisateurUrl.setIdUtilisateur(fichierUtilisateurBody.getIdUtilisateur());
			}

			if (fichierUtilisateurBody.getType() != null) {
				fichierUtilisateurUrl.setType(fichierUtilisateurBody.getType());
			}

			if (fichierUtilisateurBody.getEmplacement() != null) {
				fichierUtilisateurUrl.setEmplacement(fichierUtilisateurBody.getEmplacement());
			}

			fichierUtilisateurService.saveFichierUtilisateur(fichierUtilisateurUrl);
			return fichierUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/fichierutilisateur/{id}")
	public void deleteFichierUtilisateur(@PathVariable("id") final Long id) {
		fichierUtilisateurService.deleteFichierUtilisateur(id);
	}

}
