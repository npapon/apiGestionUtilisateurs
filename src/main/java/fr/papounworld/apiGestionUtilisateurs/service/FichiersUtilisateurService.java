package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.FichiersUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.FichiersUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class FichiersUtilisateurService {
	@Autowired
	private FichiersUtilisateurRepository FichiersUtilisateurRepository;

	public Iterable<FichiersUtilisateur> getFichiersUtilisateurs() {
		return FichiersUtilisateurRepository.findAll();
	}

	public Optional<FichiersUtilisateur> getFichiersUtilisateur(final Long id) {
		return FichiersUtilisateurRepository.findById(id);

	}

	public void deleteFichiersUtilisateur(final long id) {

		FichiersUtilisateurRepository.deleteById(id);
	}

	public FichiersUtilisateur saveFichiersUtilisateur(FichiersUtilisateur FichiersUtilisateur) {

		FichiersUtilisateurRepository.save(FichiersUtilisateur);
		return FichiersUtilisateur;

	}

}
