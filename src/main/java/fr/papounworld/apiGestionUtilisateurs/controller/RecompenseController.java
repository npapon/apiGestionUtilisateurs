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

import fr.papounworld.apiGestionUtilisateurs.model.Recompense;
import fr.papounworld.apiGestionUtilisateurs.service.RecompenseService;

@RestController
public class RecompenseController {

	@Autowired
	private RecompenseService recompenseService;

	@GetMapping("/recompense")
	public Iterable<Recompense> getRecompenses() {
		return recompenseService.getRecompenses();
	}

	@GetMapping("/recompense/{id}")
	public Recompense getRecompense(@PathVariable("id") final Long id) {
		Optional<Recompense> recompense = recompenseService.getRecompense(id);
		if (recompense.isPresent()) {
			return recompense.get();
		} else {
			return null;
		}
	}

	@PostMapping("/recompense")
	public Recompense createRecompense(@RequestBody Recompense recompense) {
		return recompenseService.saveRecompense(recompense);
	}

	@PutMapping("/recompense/{id}")
	public Recompense updateRecompense(@PathVariable("id") final Long id, @RequestBody Recompense recompenseBody) {

		Optional<Recompense> optionalRecompenseUrl = recompenseService.getRecompense(id);
		if (optionalRecompenseUrl.isPresent()) {
			Recompense recompenseUrl = optionalRecompenseUrl.get();
			if (recompenseBody.getLibelle() != null) {
				recompenseUrl.setLibelle(recompenseBody.getLibelle());
			}

			recompenseService.saveRecompense(recompenseUrl);
			return recompenseUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/recompense/{id}")
	public void deleteRecompense(@PathVariable("id") final Long id) {
		recompenseService.deleteRecompense(id);
	}

}
