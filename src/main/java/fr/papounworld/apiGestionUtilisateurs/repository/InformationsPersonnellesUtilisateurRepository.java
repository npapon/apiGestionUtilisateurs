package fr.papounworld.apiGestionUtilisateurs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.papounworld.apiGestionUtilisateurs.model.InformationsPersonnellesUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;

	@Repository
	public interface InformationsPersonnellesUtilisateurRepository extends CrudRepository<InformationsPersonnellesUtilisateur, Long> {

	}


