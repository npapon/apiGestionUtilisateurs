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

import fr.papounworld.apiGestionUtilisateurs.model.FichiersUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.FichiersUtilisateurService;

@RestController
public class FichiersUtilisateurController {

	@Autowired
	private FichiersUtilisateurService fichiersUtilisateurService;

	@GetMapping("/fichiersUtilisateur")
	public Iterable<FichiersUtilisateur> getFichiersUtilisateurs() {
		return fichiersUtilisateurService.getFichiersUtilisateurs();
	}

	@GetMapping("/fichiersUtilisateur/{id}")
	public FichiersUtilisateur getFichiersUtilisateur(@PathVariable("id") final Long id) {
		Optional<FichiersUtilisateur> fichiersUtilisateur = fichiersUtilisateurService.getFichiersUtilisateur(id);
		if (fichiersUtilisateur.isPresent()) {
			return fichiersUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/fichiersUtilisateur")
	public FichiersUtilisateur createFichiersUtilisateur(@RequestBody FichiersUtilisateur fichiersUtilisateur) {
		return fichiersUtilisateurService.saveFichiersUtilisateur(fichiersUtilisateur);
	}

	@PutMapping("/fichiersUtilisateur/{id}")
	public FichiersUtilisateur updateFichiersUtilisateur(@PathVariable("id") final Long id,
			@RequestBody FichiersUtilisateur fichiersUtilisateurBody) {

		Optional<FichiersUtilisateur> optionalFichiersUtilisateurUrl = fichiersUtilisateurService
				.getFichiersUtilisateur(id);
		if (optionalFichiersUtilisateurUrl.isPresent()) {
			FichiersUtilisateur fichiersUtilisateurUrl = optionalFichiersUtilisateurUrl.get();

			if (fichiersUtilisateurBody.getIdUtilisateur() != 0) {
				fichiersUtilisateurUrl.setIdUtilisateur(fichiersUtilisateurBody.getIdUtilisateur());
			}

			if (fichiersUtilisateurBody.getType() != null) {
				fichiersUtilisateurUrl.setType(fichiersUtilisateurBody.getType());
			}

			if (fichiersUtilisateurBody.getEmplacement() != null) {
				fichiersUtilisateurUrl.setEmplacement(fichiersUtilisateurBody.getEmplacement());
			}

			fichiersUtilisateurService.saveFichiersUtilisateur(fichiersUtilisateurUrl);
			return fichiersUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/fichiersUtilisateur/{id}")
	public void deleteFichiersUtilisateur(@PathVariable("id") final Long id) {
		fichiersUtilisateurService.deleteFichiersUtilisateur(id);
	}

}
