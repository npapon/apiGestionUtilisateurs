package fr.papounworld.apiGestionUtilisateurs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;



@RestController
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("/utilisateurs")
	public Iterable<Utilisateur> getUtilisateurs(){
		return utilisateurService.getUtilisateurs();
	}
	
	@GetMapping("/utilisateur/{id}")
	public Utilisateur getUtilisateur(@PathVariable("id") final Long id) {
		Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateur(id);
		if(utilisateur.isPresent()) {
			return utilisateur.get();
		} else {
			return null;
		}
	}
	
	@PostMapping("/utilisateur")
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.saveUtilisateur(utilisateur);
	}
	


	
	@PutMapping("/utilisateur/{id}")
	public Utilisateur updateUtilisateur(@PathVariable("id") final Long id,  @RequestBody  Utilisateur utilisateurBody) {
		
		Optional<Utilisateur> optionalUtilisateurUrl  = utilisateurService.getUtilisateur(id);
		if(optionalUtilisateurUrl.isPresent())
		{
			Utilisateur utilisateurUrl = optionalUtilisateurUrl.get();
			if(utilisateurBody.getLogin()!=null)
			{utilisateurUrl.setLogin(utilisateurBody.getLogin());}
			
			if(utilisateurBody.getMotdepasse()!=null)
			{utilisateurUrl.setMotdepasse(utilisateurBody.getMotdepasse());}
			

			if(utilisateurBody.getInformationsPersonnellesUtilisateur()!=null)
			{utilisateurUrl.setInformationsPersonnellesUtilisateur(utilisateurBody.getInformationsPersonnellesUtilisateur());}
			
			
			utilisateurService.saveUtilisateur(utilisateurUrl);
			return utilisateurUrl;
		}
		else {
		
			return null;
		}
	}
	
	@DeleteMapping("/utilisateur/{id}")
	public void deleteUtilisateur(@PathVariable("id") final Long id) {
		utilisateurService.deleteUtilisateur(id);
	}

}
