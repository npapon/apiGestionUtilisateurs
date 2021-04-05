package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.FichierUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.FichierUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class FichierUtilisateurService {
	@Autowired
	private FichierUtilisateurRepository FichierUtilisateurRepository;

	public Iterable<FichierUtilisateur> getFichierUtilisateurs() {
		return FichierUtilisateurRepository.findAll();
	}

	public Optional<FichierUtilisateur> getFichierUtilisateur(final Long id) {
		return FichierUtilisateurRepository.findById(id);

	}

	public void deleteFichierUtilisateur(final long id) {

		FichierUtilisateurRepository.deleteById(id);
	}

	public FichierUtilisateur saveFichierUtilisateur(FichierUtilisateur fichierUtilisateur) {

		FichierUtilisateurRepository.save(fichierUtilisateur);
		return fichierUtilisateur;

	}

}
