package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.Privilege;
import fr.papounworld.apiGestionUtilisateurs.repository.PrivilegeRepository;
import lombok.Data;

@Data
@Service
public class PrivilegeService {
	
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	public Iterable<Privilege> getPrivileges(){	
		return privilegeRepository.findAll();
	}	
	
	public Optional<Privilege> getPrivilege(final Long id){
		return privilegeRepository.findById(id);
		
	}
	
	public void deletePrivilege(final long id) {
		
		privilegeRepository.deleteById(id);
	}
	
	
	public Privilege savePrivilege(Privilege Privilege) {

		privilegeRepository.save(Privilege);
		return Privilege;
		
	}

}
