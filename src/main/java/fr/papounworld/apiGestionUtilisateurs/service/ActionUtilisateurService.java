package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.ActionUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.ActionUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class ActionUtilisateurService {

	@Autowired
	private ActionUtilisateurRepository actionUtilisateurRepository;

	public Iterable<ActionUtilisateur> getActionUtilisateur() {
		return actionUtilisateurRepository.findAll();
	}

	public Optional<ActionUtilisateur> getActionUtilisateur(final Long id) {
		return actionUtilisateurRepository.findById(id);

	}

	public void deleteActionUtilisateur(final long id) {

		actionUtilisateurRepository.deleteById(id);
	}

	public ActionUtilisateur saveActionUtilisateur(ActionUtilisateur actionUtilisateur) {

		actionUtilisateurRepository.save(actionUtilisateur);
		return actionUtilisateur;

	}

}
