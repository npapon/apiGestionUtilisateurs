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

import fr.papounworld.apiGestionUtilisateurs.model.ActionApplicativeScript;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeScriptService;

@RestController
public class ActionApplicativeScriptController {

	@Autowired
	private ActionApplicativeScriptService actionApplicativeScriptService;

	@GetMapping("/actionapplicativescript")
	public Iterable<ActionApplicativeScript> getActionsApplicative() {
		return actionApplicativeScriptService.getActionsApplicativeScript();
	}

	@GetMapping("/actionapplicativescript/{id}")
	public ActionApplicativeScript getActionsApplicative(@PathVariable("id") final Long id) {
		Optional<ActionApplicativeScript> actionApplicative = actionApplicativeScriptService
				.getActionApplicativeScript(id);
		if (actionApplicative.isPresent()) {
			return actionApplicative.get();
		} else {
			return null;
		}
	}

	@PostMapping("/actionapplicativescript")
	public ActionApplicativeScript createActionApplicativeScriptScript(
			@RequestBody ActionApplicativeScript actionApplicative) {

		return actionApplicativeScriptService.saveActionApplicativeScript(actionApplicative);
	}

	@PutMapping("/actionapplicativescript/{id}")
	public ActionApplicativeScript updateActionsApplicative(@PathVariable("id") final Long id,
			@RequestBody ActionApplicativeScript actionApplicativeScriptBody) {

		Optional<ActionApplicativeScript> optionalActionsApplicativeScriptUrl = actionApplicativeScriptService
				.getActionApplicativeScript(id);
		if (optionalActionsApplicativeScriptUrl.isPresent()) {
			ActionApplicativeScript actionApplicativeUrl = optionalActionsApplicativeScriptUrl.get();
			if (actionApplicativeScriptBody.getLibelle() != null) {
				actionApplicativeUrl.setLibelle(actionApplicativeScriptBody.getLibelle());
			}

			actionApplicativeScriptService.saveActionApplicativeScript(actionApplicativeUrl);
			return actionApplicativeUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/actionapplicativescript/{id}")
	public void deleteActionsApplicative(@PathVariable("id") final Long id) {
		actionApplicativeScriptService.deleteActionApplicativeScript(id);
	}

}
