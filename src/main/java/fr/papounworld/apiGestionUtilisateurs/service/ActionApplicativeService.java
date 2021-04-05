package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.ActionApplicative;
import fr.papounworld.apiGestionUtilisateurs.repository.ActionApplicativeRepository;
import lombok.Data;

@Data
@Service
public class ActionApplicativeService {

	@Autowired
	private ActionApplicativeRepository actionApplicativeRepository;

	public Iterable<ActionApplicative> getActionApplicative() {
		return actionApplicativeRepository.findAll();
	}

	public Optional<ActionApplicative> getActionApplicative(final Long id) {
		return actionApplicativeRepository.findById(id);

	}

	public void deleteActionApplicative(final long id) {

		actionApplicativeRepository.deleteById(id);
	}

	public ActionApplicative saveActionApplicative(ActionApplicative actionApplicative) {

		actionApplicativeRepository.save(actionApplicative);
		return actionApplicative;

	}

}
