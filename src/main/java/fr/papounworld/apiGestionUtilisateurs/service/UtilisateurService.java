package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;
import fr.papounworld.apiGestionUtilisateurs.repository.UtilisateurRepository;
import lombok.Data;

@Data
@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public Iterable<Utilisateur> getUtilisateurs(){	
		return utilisateurRepository.findAll();
	}	
	
	public Optional<Utilisateur> getUtilisateur(final Long id){
		return utilisateurRepository.findById(id);
		
	}
	
	public void deleteUtilisateur(final long id) {
		
		utilisateurRepository.deleteById(id);
	}
	
	
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {

		utilisateurRepository.save(utilisateur);
		return utilisateur;
		
	}


}
