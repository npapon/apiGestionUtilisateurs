package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.InformationPersonnelleUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.InformationPersonnelleUtilisateurRepository;
import lombok.Data;

@Data
@Service
public class InformationPersonnelleUtilisateurService {

	@Autowired
	private InformationPersonnelleUtilisateurRepository informationPersonnelleUtilisateurRepository;

	public Iterable<InformationPersonnelleUtilisateur> getInformationPersonnelleUtilisateur() {
		return informationPersonnelleUtilisateurRepository.findAll();
	}

	public Optional<InformationPersonnelleUtilisateur> getInformationPersonnellesUtilisateur(final Long id) {
		return informationPersonnelleUtilisateurRepository.findById(id);

	}

	public void deleteInformationPersonnellesUtilisateur(final long id) {

		informationPersonnelleUtilisateurRepository.deleteById(id);
	}

	public InformationPersonnelleUtilisateur saveInformationPersonnellesUtilisateur(
			InformationPersonnelleUtilisateur informationPersonnelleUtilisateur) {

		informationPersonnelleUtilisateurRepository.save(informationPersonnelleUtilisateur);
		return informationPersonnelleUtilisateur;

	}

}
