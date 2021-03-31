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

import fr.papounworld.apiGestionUtilisateurs.model.InformationsPersonnellesUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.InformationsPersonnellesUtilisateurService;

@RestController
public class InformationsPersonnellesUtilisateurController {

	@Autowired
	private InformationsPersonnellesUtilisateurService informationsPersonnellesUtilisateurService;

	@GetMapping("/informationpersonnelle")
	public Iterable<InformationsPersonnellesUtilisateur> getInformationsPersonnellesUtilisateur() {
		return informationsPersonnellesUtilisateurService.getInformationsPersonnellesUtilisateur();
	}

	@GetMapping("/informationpersonnelle/{id}")
	public InformationsPersonnellesUtilisateur getInformationPersonnellesUtilisateur(
			@PathVariable("id") final Long id) {
		Optional<InformationsPersonnellesUtilisateur> informationsPersonnellesUtilisateurOptional = informationsPersonnellesUtilisateurService
				.getInformationPersonnellesUtilisateur(id);
		if (informationsPersonnellesUtilisateurOptional.isPresent()) {
			return informationsPersonnellesUtilisateurOptional.get();
		} else {
			return null;
		}
	}

	@PostMapping("/informationpersonnelle")
	public InformationsPersonnellesUtilisateur createInformationPersonnellesUtilisateur(
			@RequestBody InformationsPersonnellesUtilisateur informationsPersonnellesUtilisateur) {
		return informationsPersonnellesUtilisateurService
				.saveInformationPersonnellesUtilisateur(informationsPersonnellesUtilisateur);
	}

	@PutMapping("/informationpersonnelle/{id}")
	public InformationsPersonnellesUtilisateur updateInformationPersonnellesUtilisateur(
			@PathVariable("id") final Long id,
			@RequestBody InformationsPersonnellesUtilisateur informationsPersonnellesUtilisateurBody) {

		Optional<InformationsPersonnellesUtilisateur> informationsPersonnellesUtilisateurOptionalUrl = informationsPersonnellesUtilisateurService
				.getInformationPersonnellesUtilisateur(id);
		if (informationsPersonnellesUtilisateurOptionalUrl.isPresent()) {
			InformationsPersonnellesUtilisateur informationsPersonnellesUtilisateurUrl = informationsPersonnellesUtilisateurOptionalUrl
					.get();
			if (informationsPersonnellesUtilisateurBody.getPrenom() != null) {
				informationsPersonnellesUtilisateurUrl.setPrenom(informationsPersonnellesUtilisateurBody.getPrenom());
			}

			if (informationsPersonnellesUtilisateurBody.getNom() != null) {
				informationsPersonnellesUtilisateurUrl.setNom(informationsPersonnellesUtilisateurBody.getNom());
			}

			if (informationsPersonnellesUtilisateurBody.getEmail() != null) {
				informationsPersonnellesUtilisateurUrl.setEmail(informationsPersonnellesUtilisateurBody.getEmail());
			}

			if (informationsPersonnellesUtilisateurBody.getAdresse() != null) {
				informationsPersonnellesUtilisateurUrl.setAdresse(informationsPersonnellesUtilisateurBody.getAdresse());
			}

			if (informationsPersonnellesUtilisateurBody.getTelephone() != null) {
				informationsPersonnellesUtilisateurUrl
						.setTelephone(informationsPersonnellesUtilisateurBody.getTelephone());
			}

			return informationsPersonnellesUtilisateurUrl;

		} else {

			return null;
		}
	}

	@DeleteMapping("/informationpersonnelle/{id}")
	public void deleteInformationPersonnelle(@PathVariable("id") final Long id) {
		informationsPersonnellesUtilisateurService.deleteInformationPersonnellesUtilisateur(id);
	}

}
