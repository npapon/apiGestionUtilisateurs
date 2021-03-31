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

import fr.papounworld.apiGestionUtilisateurs.model.AssociationActionsUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.AssociationActionsUtilisateurService;

@RestController
public class AssociationActionsUtilisateurController {

	@Autowired
	private AssociationActionsUtilisateurService associationActionsUtilisateurService;

	@GetMapping("/associationactionsutilisateur")
	public Iterable<AssociationActionsUtilisateur> getAssociationActionsUtilisateurs() {
		return associationActionsUtilisateurService.getAllAssociationActionsUtilisateurs();
	}

	@GetMapping("/associationactionsutilisateur/{id}")
	public AssociationActionsUtilisateur getAssociationActionsUtilisateur(@PathVariable("id") final Long id) {
		Optional<AssociationActionsUtilisateur> associationActionsUtilisateur = associationActionsUtilisateurService
				.getAssociationActionsUtilisateur(id);
		if (associationActionsUtilisateur.isPresent()) {
			return associationActionsUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/associationactionsutilisateur")
	public AssociationActionsUtilisateur createAssociationActionsUtilisateur(
			@RequestBody AssociationActionsUtilisateur associationActionsUtilisateur) {
		return associationActionsUtilisateurService.saveAssociationActionsUtilisateur(associationActionsUtilisateur);
	}

	@PutMapping("/associationactionsutilisateur/{id}")
	public AssociationActionsUtilisateur updateAssociationActionsUtilisateur(@PathVariable("id") final Long id,
			@RequestBody AssociationActionsUtilisateur associationActionsUtilisateurBody) {

		Optional<AssociationActionsUtilisateur> optionalAssociationActionsUtilisateurUrl = associationActionsUtilisateurService
				.getAssociationActionsUtilisateur(id);
		if (optionalAssociationActionsUtilisateurUrl.isPresent()) {
			AssociationActionsUtilisateur associationActionsUtilisateurUrl = optionalAssociationActionsUtilisateurUrl
					.get();

			associationActionsUtilisateurService.saveAssociationActionsUtilisateur(associationActionsUtilisateurUrl);

			if (associationActionsUtilisateurBody.getIdAction() != 0) {
				associationActionsUtilisateurUrl.setIdAction(associationActionsUtilisateurBody.getIdAction());
			}

			if (associationActionsUtilisateurBody.getIdUtilisateur() != 0) {
				associationActionsUtilisateurUrl.setIdUtilisateur(associationActionsUtilisateurBody.getIdUtilisateur());
			}

			return associationActionsUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/associationactionsutilisateur/{id}")
	public void deleteAssociationActionsUtilisateur(@PathVariable("id") final Long id) {
		associationActionsUtilisateurService.deleteAssociationActionsUtilisateur(id);
	}

}
