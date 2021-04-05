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

import fr.papounworld.apiGestionUtilisateurs.model.InformationPersonnelleUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.InformationPersonnelleUtilisateurService;

@RestController
public class InformationPersonnelleUtilisateurController {

	@Autowired
	private InformationPersonnelleUtilisateurService informationPersonnelleUtilisateurService;

	@GetMapping("/informationpersonnelle")
	public Iterable<InformationPersonnelleUtilisateur> getInformationPersonnelleUtilisateur() {
		return informationPersonnelleUtilisateurService.getInformationPersonnelleUtilisateur();
	}

	@GetMapping("/informationpersonnelle/{id}")
	public InformationPersonnelleUtilisateur getInformationPersonnellesUtilisateur(@PathVariable("id") final Long id) {
		Optional<InformationPersonnelleUtilisateur> informationPersonnelleUtilisateurOptional = informationPersonnelleUtilisateurService
				.getInformationPersonnellesUtilisateur(id);
		if (informationPersonnelleUtilisateurOptional.isPresent()) {
			return informationPersonnelleUtilisateurOptional.get();
		} else {
			return null;
		}
	}

	@PostMapping("/informationpersonnelle")
	public InformationPersonnelleUtilisateur createInformationPersonnellesUtilisateur(
			@RequestBody InformationPersonnelleUtilisateur informationPersonnelleUtilisateur) {
		return informationPersonnelleUtilisateurService
				.saveInformationPersonnellesUtilisateur(informationPersonnelleUtilisateur);
	}

	@PutMapping("/informationpersonnelle/{id}")
	public InformationPersonnelleUtilisateur updateInformationPersonnellesUtilisateur(@PathVariable("id") final Long id,
			@RequestBody InformationPersonnelleUtilisateur informationPersonnelleUtilisateurBody) {

		Optional<InformationPersonnelleUtilisateur> informationPersonnelleUtilisateurOptionalUrl = informationPersonnelleUtilisateurService
				.getInformationPersonnellesUtilisateur(id);
		if (informationPersonnelleUtilisateurOptionalUrl.isPresent()) {
			InformationPersonnelleUtilisateur informationPersonnelleUtilisateurUrl = informationPersonnelleUtilisateurOptionalUrl
					.get();
			if (informationPersonnelleUtilisateurBody.getPrenom() != null) {
				informationPersonnelleUtilisateurUrl.setPrenom(informationPersonnelleUtilisateurBody.getPrenom());
			}

			if (informationPersonnelleUtilisateurBody.getNom() != null) {
				informationPersonnelleUtilisateurUrl.setNom(informationPersonnelleUtilisateurBody.getNom());
			}

			if (informationPersonnelleUtilisateurBody.getEmail() != null) {
				informationPersonnelleUtilisateurUrl.setEmail(informationPersonnelleUtilisateurBody.getEmail());
			}

			if (informationPersonnelleUtilisateurBody.getAdresse() != null) {
				informationPersonnelleUtilisateurUrl.setAdresse(informationPersonnelleUtilisateurBody.getAdresse());
			}

			if (informationPersonnelleUtilisateurBody.getTelephone() != null) {
				informationPersonnelleUtilisateurUrl.setTelephone(informationPersonnelleUtilisateurBody.getTelephone());
			}

			return informationPersonnelleUtilisateurUrl;

		} else {

			return null;
		}
	}

	@DeleteMapping("/informationpersonnelle/{id}")
	public void deleteInformationPersonnelle(@PathVariable("id") final Long id) {
		informationPersonnelleUtilisateurService.deleteInformationPersonnellesUtilisateur(id);
	}

}
