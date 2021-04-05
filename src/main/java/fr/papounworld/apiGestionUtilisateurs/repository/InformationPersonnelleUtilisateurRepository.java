package fr.papounworld.apiGestionUtilisateurs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.papounworld.apiGestionUtilisateurs.model.InformationPersonnelleUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;

	@Repository
	public interface InformationPersonnelleUtilisateurRepository extends CrudRepository<InformationPersonnelleUtilisateur, Long> {

	}


