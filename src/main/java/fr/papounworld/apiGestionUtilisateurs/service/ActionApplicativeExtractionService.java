package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.ActionApplicativeExtraction;
import fr.papounworld.apiGestionUtilisateurs.repository.ActionApplicativeExtractionRepository;
import lombok.Data;

@Data
@Service
public class ActionApplicativeExtractionService {
	@Autowired
	private ActionApplicativeExtractionRepository actionApplicativeExtractionRepository;

	public Iterable<ActionApplicativeExtraction> getActionsApplicativeExtraction() {
		return actionApplicativeExtractionRepository.findAll();
	}

	public Optional<ActionApplicativeExtraction> getActionApplicativeExtraction(final Long id) {
		return actionApplicativeExtractionRepository.findById(id);

	}

	public void deleteActionApplicativeExtraction(final long id) {

		actionApplicativeExtractionRepository.deleteById(id);
	}

	public ActionApplicativeExtraction saveActionApplicativeExtraction(
			ActionApplicativeExtraction actionApplicativeExtraction) {

		actionApplicativeExtractionRepository.save(actionApplicativeExtraction);
		return actionApplicativeExtraction;

	}

}
