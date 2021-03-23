package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.AssociationRolesUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.AssociationRolesUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class AssociationRolesUtilisateurService {

	@Autowired
	private AssociationRolesUtilisateurRepository associationRolesUtilisateurRepository;

	public Iterable<AssociationRolesUtilisateur> getAllAssociationRolesUtilisateurs() {
		return associationRolesUtilisateurRepository.findAll();
	}

	public Optional<AssociationRolesUtilisateur> getAssociationRolesUtilisateur(final Long id) {
		return associationRolesUtilisateurRepository.findById(id);

	}

	public void deleteAssociationRolesUtilisateur(final long id) {

		associationRolesUtilisateurRepository.deleteById(id);
	}

	public AssociationRolesUtilisateur saveAssociationRolesUtilisateur(
			AssociationRolesUtilisateur AssociationRolesUtilisateur) {

		associationRolesUtilisateurRepository.save(AssociationRolesUtilisateur);
		return AssociationRolesUtilisateur;

	}

}
