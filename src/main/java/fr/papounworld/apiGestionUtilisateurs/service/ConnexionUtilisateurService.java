package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.ConnexionUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.ConnexionUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class ConnexionUtilisateurService {

	@Autowired
	private ConnexionUtilisateurRepository connexionsUtilisateurRepository;

	public Iterable<ConnexionUtilisateur> getConnexionUtilisateurs() {
		return connexionsUtilisateurRepository.findAll();
	}

	public Optional<ConnexionUtilisateur> getConnexionUtilisateur(final Long id) {
		return connexionsUtilisateurRepository.findById(id);

	}

	public void deleteConnexionUtilisateur(final long id) {

		connexionsUtilisateurRepository.deleteById(id);
	}

	public ConnexionUtilisateur saveConnexionUtilisateur(ConnexionUtilisateur connexionsUtilisateur) {

		connexionsUtilisateurRepository.save(connexionsUtilisateur);
		return connexionsUtilisateur;

	}

}
