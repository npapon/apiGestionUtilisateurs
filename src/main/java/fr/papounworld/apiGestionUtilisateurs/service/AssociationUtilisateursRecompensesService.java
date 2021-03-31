package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.AssociationUtilisateursRecompenses;
import fr.papounworld.apiGestionUtilisateurs.repository.AssociationUtilisateursRecompensesRepository;
import lombok.Data;

@Data
@Service
public class AssociationUtilisateursRecompensesService {

	@Autowired
	private AssociationUtilisateursRecompensesRepository associationUtilisateursRecompensesRepository;

	public Iterable<AssociationUtilisateursRecompenses> getAllAssociationUtilisateursRecompensess() {
		return associationUtilisateursRecompensesRepository.findAll();
	}

	public Optional<AssociationUtilisateursRecompenses> getAssociationUtilisateursRecompenses(final Long id) {
		return associationUtilisateursRecompensesRepository.findById(id);

	}

	public void deleteAssociationUtilisateursRecompenses(final long id) {

		associationUtilisateursRecompensesRepository.deleteById(id);
	}

	public AssociationUtilisateursRecompenses saveAssociationUtilisateursRecompenses(
			AssociationUtilisateursRecompenses associationUtilisateursRecompenses) {

		associationUtilisateursRecompensesRepository.save(associationUtilisateursRecompenses);
		return associationUtilisateursRecompenses;

	}

}
