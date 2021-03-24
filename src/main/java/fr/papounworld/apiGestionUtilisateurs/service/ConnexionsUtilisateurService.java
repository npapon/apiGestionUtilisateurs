package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.ConnexionsUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.ConnexionsUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class ConnexionsUtilisateurService {

	@Autowired
	private ConnexionsUtilisateurRepository connexionsUtilisateurRepository;

	public Iterable<ConnexionsUtilisateur> getConnexionsUtilisateurs() {
		return connexionsUtilisateurRepository.findAll();
	}

	public Optional<ConnexionsUtilisateur> getConnexionsUtilisateur(final Long id) {
		return connexionsUtilisateurRepository.findById(id);

	}

	public void deleteConnexionsUtilisateur(final long id) {

		connexionsUtilisateurRepository.deleteById(id);
	}

	public ConnexionsUtilisateur saveConnexionsUtilisateur(ConnexionsUtilisateur ConnexionsUtilisateur) {

		connexionsUtilisateurRepository.save(ConnexionsUtilisateur);
		return ConnexionsUtilisateur;

	}

}
