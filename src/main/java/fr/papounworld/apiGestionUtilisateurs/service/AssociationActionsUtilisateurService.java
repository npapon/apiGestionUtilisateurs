package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.AssociationActionsUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.AssociationActionsUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class AssociationActionsUtilisateurService {

	@Autowired
	private AssociationActionsUtilisateurRepository associationActionsUtilisateurRepository;

	public Iterable<AssociationActionsUtilisateur> getAllAssociationActionsUtilisateurs() {
		return associationActionsUtilisateurRepository.findAll();
	}

	public Optional<AssociationActionsUtilisateur> getAssociationActionsUtilisateur(final Long id) {
		return associationActionsUtilisateurRepository.findById(id);

	}

	public void deleteAssociationActionsUtilisateur(final long id) {

		associationActionsUtilisateurRepository.deleteById(id);
	}

	public AssociationActionsUtilisateur saveAssociationActionsUtilisateur(
			AssociationActionsUtilisateur AssociationActionsUtilisateur) {

		associationActionsUtilisateurRepository.save(AssociationActionsUtilisateur);
		return AssociationActionsUtilisateur;

	}

}
