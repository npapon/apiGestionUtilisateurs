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
	
	
	public Iterable<InformationsPersonnellesUtilisateur> getInformationsPersonnellesUtilisateur(){	
		return informationsPersonnellesUtilisateurRepository.findAll();
	}	
	
	public Optional<InformationsPersonnellesUtilisateur> getInformationPersonnellesUtilisateur(final Long id){
		return informationsPersonnellesUtilisateurRepository.findById(id);
		
	}
	
	public void deleteInformationPersonnellesUtilisateur(final long id) {
		
		informationsPersonnellesUtilisateurRepository.deleteById(id);
	}
	
	
	public InformationsPersonnellesUtilisateur saveInformationPersonnellesUtilisateur(InformationsPersonnellesUtilisateur informationsPersonnellesUtilisateur) {

		informationsPersonnellesUtilisateurRepository.save(informationsPersonnellesUtilisateur);
		return informationsPersonnellesUtilisateur;
		
	}
	

}
