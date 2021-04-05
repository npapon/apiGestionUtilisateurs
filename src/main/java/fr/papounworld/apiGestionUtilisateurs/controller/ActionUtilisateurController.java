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

import fr.papounworld.apiGestionUtilisateurs.model.ActionUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.ActionUtilisateurService;

@RestController
public class ActionUtilisateurController {

	@Autowired
	private ActionUtilisateurService actionUtilisateurService;

	@GetMapping("/actionutilisateur")
	public Iterable<ActionUtilisateur> getActionUtilisateur() {
		return actionUtilisateurService.getActionUtilisateur();
	}

	@GetMapping("/actionutilisateur/{id}")
	public ActionUtilisateur getActionsUtilisateur(@PathVariable("id") final Long id) {
		Optional<ActionUtilisateur> actionUtilisateur = actionUtilisateurService.getActionUtilisateur(id);
		if (actionUtilisateur.isPresent()) {
			return actionUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/actionutilisateur")
	public ActionUtilisateur createActionsUtilisateur(@RequestBody ActionUtilisateur actionUtilisateur) {
		return actionUtilisateurService.saveActionUtilisateur(actionUtilisateur);
	}

	@PutMapping("/actionutilisateur/{id}")
	public ActionUtilisateur updateActionsUtilisateur(@PathVariable("id") final Long id,
			@RequestBody ActionUtilisateur actionUtilisateurBody) {

		Optional<ActionUtilisateur> optionalActionsUtilisateurUrl = actionUtilisateurService.getActionUtilisateur(id);
		if (optionalActionsUtilisateurUrl.isPresent()) {
			ActionUtilisateur actionUtilisateurUrl = optionalActionsUtilisateurUrl.get();
			if (actionUtilisateurBody.getAction() != null) {
				actionUtilisateurUrl.setAction(actionUtilisateurBody.getAction());
			}

			if (actionUtilisateurBody.getActionDate() != null) {
				actionUtilisateurUrl.setActionDate(actionUtilisateurBody.getActionDate());
			}

			actionUtilisateurService.saveActionUtilisateur(actionUtilisateurUrl);
			return actionUtilisateurUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/actionutilisateur/{id}")
	public void deleteActionsUtilisateur(@PathVariable("id") final Long id) {
		actionUtilisateurService.deleteActionUtilisateur(id);
	}

}
