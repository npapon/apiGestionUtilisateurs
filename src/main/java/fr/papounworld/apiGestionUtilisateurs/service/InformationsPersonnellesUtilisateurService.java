package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.InformationsPersonnellesUtilisateur;
import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.InformationsPersonnellesUtilisateurRepository;
import fr.papounworld.apiGestionUtilisateurs.repository.UtilisateurRepository;
import lombok.Data;

@Data
@Service
public class InformationsPersonnellesUtilisateurService {
	
	@Autowired
	private InformationsPersonnellesUtilisateurRepository informationsPersonnellesUtilisateurRepository;
	
	
	public Optional<InformationsPersonnellesUtilisateur> getInformationsPersonnellesUtilisateur(final Long id){
		return informationsPersonnellesUtilisateurRepository.findById(id);
		
	}

}
