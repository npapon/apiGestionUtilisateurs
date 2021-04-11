package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.ActionApplicativeScript;
import fr.papounworld.apiGestionUtilisateurs.repository.ActionApplicativeScriptRepository;
import lombok.Data;

@Data
@Service
public class ActionApplicativeScriptService {

	@Autowired
	private ActionApplicativeScriptRepository actionApplicativeScriptRepository;

	public Iterable<ActionApplicativeScript> getActionsApplicativeScript() {
		return actionApplicativeScriptRepository.findAll();
	}

	public Optional<ActionApplicativeScript> getActionApplicativeScript(final Long id) {
		return actionApplicativeScriptRepository.findById(id);

	}

	public void deleteActionApplicativeScript(final long id) {

		actionApplicativeScriptRepository.deleteById(id);
	}

	public ActionApplicativeScript saveActionApplicativeScript(ActionApplicativeScript actionApplicativeScript) {

		actionApplicativeScriptRepository.save(actionApplicativeScript);
		return actionApplicativeScript;

	}

}
