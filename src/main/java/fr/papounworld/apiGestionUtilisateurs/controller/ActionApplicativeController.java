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

import fr.papounworld.apiGestionUtilisateurs.model.ActionApplicative;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;

@RestController
public class ActionApplicativeController {

	@Autowired
	private ActionApplicativeService actionApplicativeService;

	@GetMapping("/actionapplicative")
	public Iterable<ActionApplicative> getActionApplicative() {
		return actionApplicativeService.getActionApplicative();
	}

	@GetMapping("/actionapplicative/{id}")
	public ActionApplicative getActionsApplicative(@PathVariable("id") final Long id) {
		Optional<ActionApplicative> actionApplicative = actionApplicativeService.getActionApplicative(id);
		if (actionApplicative.isPresent()) {
			return actionApplicative.get();
		} else {
			return null;
		}
	}

	@PostMapping("/actionapplicative")
	public ActionApplicative createActionsApplicative(@RequestBody ActionApplicative actionApplicative) {
		return actionApplicativeService.saveActionApplicative(actionApplicative);
	}

	@PutMapping("/actionapplicative/{id}")
	public ActionApplicative updateActionsApplicative(@PathVariable("id") final Long id,
			@RequestBody ActionApplicative actionApplicativeBody) {

		Optional<ActionApplicative> optionalActionsApplicativeUrl = actionApplicativeService.getActionApplicative(id);
		if (optionalActionsApplicativeUrl.isPresent()) {
			ActionApplicative actionApplicativeUrl = optionalActionsApplicativeUrl.get();
			if (actionApplicativeBody.getLibelle() != null) {
				actionApplicativeUrl.setLibelle(actionApplicativeBody.getLibelle());
			}

			actionApplicativeService.saveActionApplicative(actionApplicativeUrl);
			return actionApplicativeUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/actionapplicative/{id}")
	public void deleteActionsApplicative(@PathVariable("id") final Long id) {
		actionApplicativeService.deleteActionApplicative(id);
	}

}
