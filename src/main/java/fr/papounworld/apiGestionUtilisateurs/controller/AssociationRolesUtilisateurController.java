
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

import fr.papounworld.apiGestionUtilisateurs.model.AssociationRolesUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.AssociationRolesUtilisateurService;

@RestController
public class AssociationRolesUtilisateurController {

	@Autowired
	private AssociationRolesUtilisateurService associationRolesUtilisateurService;

	@GetMapping("/associationrolesutilisateur")
	public Iterable<AssociationRolesUtilisateur> getAssociationRolesUtilisateurs() {
		return associationRolesUtilisateurService.getAllAssociationRolesUtilisateurs();
	}

	@GetMapping("/associationrolesutilisateur/{id}")
	public AssociationRolesUtilisateur getAssociationRolesUtilisateur(@PathVariable("id") final Long id) {
		Optional<AssociationRolesUtilisateur> associationRolesUtilisateur = associationRolesUtilisateurService
				.getAssociationRolesUtilisateur(id);
		if (associationRolesUtilisateur.isPresent()) {
			return associationRolesUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/associationrolesutilisateur")
	public AssociationRolesUtilisateur createAssociationRolesUtilisateur(
			@RequestBody AssociationRolesUtilisateur associationRolesUtilisateur) {
		return associationRolesUtilisateurService.saveAssociationRolesUtilisateur(associationRolesUtilisateur);
	}

	@PutMapping("/associationrolesutilisateur/{id}")
	public AssociationRolesUtilisateur updateAssociationRolesUtilisateur(@PathVariable("id") final Long id,
			@RequestBody AssociationRolesUtilisateur associationRolesUtilisateurBody) {

		Optional<AssociationRolesUtilisateur> optionalAssociationRolesUtilisateurUrl = associationRolesUtilisateurService
				.getAssociationRolesUtilisateur(id);
		if (optionalAssociationRolesUtilisateurUrl.isPresent()) {
			AssociationRolesUtilisateur associationRolesUtilisateurUrl = optionalAssociationRolesUtilisateurUrl.get();

			associationRolesUtilisateurService.saveAssociationRolesUtilisateur(associationRolesUtilisateurUrl);

			if (associationRolesUtilisateurBody.getIdRole() != 0) {
				associationRolesUtilisateurUrl.setIdRole(associationRolesUtilisateurBody.getIdRole());
			}

			if (associationRolesUtilisateurBody.getIdUtilisateur() != 0) {
				associationRolesUtilisateurUrl.setIdUtilisateur(associationRolesUtilisateurBody.getIdUtilisateur());
			}

			return associationRolesUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/associationrolesutilisateur/{id}")
	public void deleteAssociationRolesUtilisateur(@PathVariable("id") final Long id) {
		associationRolesUtilisateurService.deleteAssociationRolesUtilisateur(id);
	}

}
