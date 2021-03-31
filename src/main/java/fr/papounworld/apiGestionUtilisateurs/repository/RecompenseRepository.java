package fr.papounworld.apiGestionUtilisateurs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.papounworld.apiGestionUtilisateurs.model.Recompense;

@Repository
public interface RecompenseRepository extends CrudRepository<Recompense, Long> {

}
