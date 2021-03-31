package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.ActionsUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.ActionsUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class ActionsUtilisateurService {

	@Autowired
	private ActionsUtilisateurRepository actionsUtilisateurRepository;

	public Iterable<ActionsUtilisateur> getActionsUtilisateurs() {
		return actionsUtilisateurRepository.findAll();
	}

	public Optional<ActionsUtilisateur> getActionsUtilisateur(final Long id) {
		return actionsUtilisateurRepository.findById(id);

	}

	public void deleteActionsUtilisateur(final long id) {

		actionsUtilisateurRepository.deleteById(id);
	}

	public ActionsUtilisateur saveActionsUtilisateur(ActionsUtilisateur actionsUtilisateur) {

		actionsUtilisateurRepository.save(actionsUtilisateur);
		return actionsUtilisateur;

	}

}
