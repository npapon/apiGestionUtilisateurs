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

import fr.papounworld.apiGestionUtilisateurs.model.Privilege;
import fr.papounworld.apiGestionUtilisateurs.service.PrivilegeService;

@RestController
public class PrivilegeController {

	@Autowired
	private PrivilegeService privilegeService;

	@GetMapping("/privilege")
	public Iterable<Privilege> getPrivileges() {
		return privilegeService.getPrivileges();
	}

	@GetMapping("/privilege/{id}")
	public Privilege getPrivilege(@PathVariable("id") final Long id) {
		Optional<Privilege> privilege = privilegeService.getPrivilege(id);
		if (privilege.isPresent()) {
			return privilege.get();
		} else {
			return null;
		}
	}

	@PostMapping("/privilege")
	public Privilege createPrivilege(@RequestBody Privilege privilege) {
		return privilegeService.savePrivilege(privilege);
	}

	@PutMapping("/privilege/{id}")
	public Privilege updatePrivilege(@PathVariable("id") final Long id, @RequestBody Privilege privilegeBody) {

		Optional<Privilege> optionalPrivilegeUrl = privilegeService.getPrivilege(id);
		if (optionalPrivilegeUrl.isPresent()) {
			Privilege privilegeUrl = optionalPrivilegeUrl.get();
			if (privilegeBody.getLibelle() != null) {
				privilegeUrl.setLibelle(privilegeBody.getLibelle());
			}

			privilegeService.savePrivilege(privilegeUrl);
			return privilegeUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/privilege/{id}")
	public void deletePrivilege(@PathVariable("id") final Long id) {
		privilegeService.deletePrivilege(id);
	}

}
