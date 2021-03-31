package fr.papounworld.apiGestionUtilisateurs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.papounworld.apiGestionUtilisateurs.model.AssociationUtilisateursRecompenses;

@Repository
public interface AssociationUtilisateursRecompensesRepository
		extends CrudRepository<AssociationUtilisateursRecompenses, Long> {

}
