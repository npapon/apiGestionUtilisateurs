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

import fr.papounworld.apiGestionUtilisateurs.model.AssociationUtilisateursRecompenses;
import fr.papounworld.apiGestionUtilisateurs.service.AssociationUtilisateursRecompensesService;

@RestController
public class AssociationUtilisateursRecompensesController {
	@Autowired
	private AssociationUtilisateursRecompensesService associationUtilisateursRecompensesService;

	@GetMapping("/associationutilisateursrecompenses")
	public Iterable<AssociationUtilisateursRecompenses> getAssociationUtilisateursRecompensess() {
		return associationUtilisateursRecompensesService.getAllAssociationUtilisateursRecompensess();
	}

	@GetMapping("/associationutilisateursrecompenses/{id}")
	public AssociationUtilisateursRecompenses getAssociationUtilisateursRecompenses(@PathVariable("id") final Long id) {
		Optional<AssociationUtilisateursRecompenses> associationUtilisateursRecompenses = associationUtilisateursRecompensesService
				.getAssociationUtilisateursRecompenses(id);
		if (associationUtilisateursRecompenses.isPresent()) {
			return associationUtilisateursRecompenses.get();
		} else {
			return null;
		}
	}

	@PostMapping("/associationutilisateursrecompenses")
	public AssociationUtilisateursRecompenses createAssociationUtilisateursRecompenses(
			@RequestBody AssociationUtilisateursRecompenses associationUtilisateursRecompenses) {
		return associationUtilisateursRecompensesService
				.saveAssociationUtilisateursRecompenses(associationUtilisateursRecompenses);
	}

	@PutMapping("/associationutilisateursrecompenses/{id}")
	public AssociationUtilisateursRecompenses updateAssociationUtilisateursRecompenses(
			@PathVariable("id") final Long id,
			@RequestBody AssociationUtilisateursRecompenses associationUtilisateursRecompensesBody) {

		Optional<AssociationUtilisateursRecompenses> optionalAssociationUtilisateursRecompensesUrl = associationUtilisateursRecompensesService
				.getAssociationUtilisateursRecompenses(id);
		if (optionalAssociationUtilisateursRecompensesUrl.isPresent()) {
			AssociationUtilisateursRecompenses associationUtilisateursRecompensesUrl = optionalAssociationUtilisateursRecompensesUrl
					.get();

			associationUtilisateursRecompensesService
					.saveAssociationUtilisateursRecompenses(associationUtilisateursRecompensesUrl);

			if (associationUtilisateursRecompensesBody.getIdUtilisateur() != 0) {
				associationUtilisateursRecompensesUrl
						.setIdUtilisateur(associationUtilisateursRecompensesBody.getIdUtilisateur());
			}

			if (associationUtilisateursRecompensesBody.getIdRecompense() != 0) {
				associationUtilisateursRecompensesUrl
						.setIdRecompense(associationUtilisateursRecompensesBody.getIdRecompense());
			}

			return associationUtilisateursRecompensesUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/associationutilisateursrecompenses/{id}")
	public void deleteAssociationUtilisateursRecompenses(@PathVariable("id") final Long id) {
		associationUtilisateursRecompensesService.deleteAssociationUtilisateursRecompenses(id);
	}

}
