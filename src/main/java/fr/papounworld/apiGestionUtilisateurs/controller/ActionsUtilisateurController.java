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

import fr.papounworld.apiGestionUtilisateurs.model.ActionsUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.ActionsUtilisateurService;

@RestController
public class ActionsUtilisateurController {

	@Autowired
	private ActionsUtilisateurService actionsUtilisateurService;

	@GetMapping("/actionsUtilisateur")
	public Iterable<ActionsUtilisateur> getActionsUtilisateurs() {
		return actionsUtilisateurService.getActionsUtilisateurs();
	}

	@GetMapping("/actionsUtilisateur/{id}")
	public ActionsUtilisateur getActionsUtilisateur(@PathVariable("id") final Long id) {
		Optional<ActionsUtilisateur> actionsUtilisateur = actionsUtilisateurService.getActionsUtilisateur(id);
		if (actionsUtilisateur.isPresent()) {
			return actionsUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/actionsUtilisateur")
	public ActionsUtilisateur createActionsUtilisateur(@RequestBody ActionsUtilisateur actionsUtilisateur) {
		return actionsUtilisateurService.saveActionsUtilisateur(actionsUtilisateur);
	}

	@PutMapping("/actionsUtilisateur/{id}")
	public ActionsUtilisateur updateActionsUtilisateur(@PathVariable("id") final Long id,
			@RequestBody ActionsUtilisateur actionsUtilisateurBody) {

		Optional<ActionsUtilisateur> optionalActionsUtilisateurUrl = actionsUtilisateurService
				.getActionsUtilisateur(id);
		if (optionalActionsUtilisateurUrl.isPresent()) {
			ActionsUtilisateur actionsUtilisateurUrl = optionalActionsUtilisateurUrl.get();
			if (actionsUtilisateurBody.getAction() != null) {
				actionsUtilisateurUrl.setAction(actionsUtilisateurBody.getAction());
			}

			if (actionsUtilisateurBody.getActionDate() != null) {
				actionsUtilisateurUrl.setActionDate(actionsUtilisateurBody.getActionDate());
			}

			actionsUtilisateurService.saveActionsUtilisateur(actionsUtilisateurUrl);
			return actionsUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/actionsUtilisateur/{id}")
	public void deleteActionsUtilisateur(@PathVariable("id") final Long id) {
		actionsUtilisateurService.deleteActionsUtilisateur(id);
	}

}
