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

import fr.papounworld.apiGestionUtilisateurs.model.ActionApplicativeExtraction;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeExtractionService;

@RestController
public class ActionApplicativeExtractionController {

	@Autowired
	private ActionApplicativeExtractionService actionApplicativeExtractionService;

	@GetMapping("/actionapplicativeextraction")
	public Iterable<ActionApplicativeExtraction> getActionsApplicative() {
		return actionApplicativeExtractionService.getActionsApplicativeExtraction();
	}

	@GetMapping("/actionapplicativeextraction/{id}")
	public ActionApplicativeExtraction getActionsApplicative(@PathVariable("id") final Long id) {
		Optional<ActionApplicativeExtraction> actionApplicative = actionApplicativeExtractionService
				.getActionApplicativeExtraction(id);
		if (actionApplicative.isPresent()) {
			return actionApplicative.get();
		} else {
			return null;
		}
	}

	@PostMapping("/actionapplicativeextraction")
	public ActionApplicativeExtraction createActionApplicativeExtractionExtraction(
			@RequestBody ActionApplicativeExtraction actionApplicative) {

		return actionApplicativeExtractionService.saveActionApplicativeExtraction(actionApplicative);
	}

	@PutMapping("/actionapplicativeextraction/{id}")
	public ActionApplicativeExtraction updateActionsApplicative(@PathVariable("id") final Long id,
			@RequestBody ActionApplicativeExtraction actionApplicativeExtractionBody) {

		Optional<ActionApplicativeExtraction> optionalActionsApplicativeExtractionUrl = actionApplicativeExtractionService
				.getActionApplicativeExtraction(id);
		if (optionalActionsApplicativeExtractionUrl.isPresent()) {
			ActionApplicativeExtraction actionApplicativeUrl = optionalActionsApplicativeExtractionUrl.get();
			if (actionApplicativeExtractionBody.getLibelle() != null) {
				actionApplicativeUrl.setLibelle(actionApplicativeExtractionBody.getLibelle());
			}

			actionApplicativeExtractionService.saveActionApplicativeExtraction(actionApplicativeUrl);
			return actionApplicativeUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/actionapplicativeextraction/{id}")
	public void deleteActionsApplicative(@PathVariable("id") final Long id) {
		actionApplicativeExtractionService.deleteActionApplicativeExtraction(id);
	}

}
