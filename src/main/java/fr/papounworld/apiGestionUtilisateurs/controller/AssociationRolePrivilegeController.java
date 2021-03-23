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

import fr.papounworld.apiGestionUtilisateurs.model.AssociationRolePrivilege;
import fr.papounworld.apiGestionUtilisateurs.service.AssociationRolePrivilegeService;

@RestController
public class AssociationRolePrivilegeController {

	@Autowired
	private AssociationRolePrivilegeService associationRolePrivilegeService;

	@GetMapping("/associationrolesprivileges")
	public Iterable<AssociationRolePrivilege> getAssociationRolePrivileges() {
		return associationRolePrivilegeService.getAssociationRolePrivileges();
	}

	@GetMapping("/associationroleprivilege/{id}")
	public AssociationRolePrivilege getAssociationRolePrivilege(@PathVariable("id") final Long id) {
		Optional<AssociationRolePrivilege> associationRolePrivilege = associationRolePrivilegeService
				.getAssociationRolePrivilege(id);
		if (associationRolePrivilege.isPresent()) {
			return associationRolePrivilege.get();
		} else {
			return null;
		}
	}

	@PostMapping("/associationroleprivilege")
	public AssociationRolePrivilege createAssociationRolePrivilege(
			@RequestBody AssociationRolePrivilege associationRolePrivilege) {
		return associationRolePrivilegeService.saveAssociationRolePrivilege(associationRolePrivilege);
	}

	@PutMapping("/associationrolePrivilege/{id}")
	public AssociationRolePrivilege updateAssociationRolePrivilege(@PathVariable("id") final Long id,
			@RequestBody AssociationRolePrivilege associationRolePrivilegeBody) {

		Optional<AssociationRolePrivilege> optionalAssociationRolePrivilegeUrl = associationRolePrivilegeService
				.getAssociationRolePrivilege(id);
		if (optionalAssociationRolePrivilegeUrl.isPresent()) {
			AssociationRolePrivilege associationRolePrivilegeUrl = optionalAssociationRolePrivilegeUrl.get();

			associationRolePrivilegeService.saveAssociationRolePrivilege(associationRolePrivilegeUrl);

			if (associationRolePrivilegeBody.getIdRole() != 0) {
				associationRolePrivilegeUrl.setIdRole(associationRolePrivilegeBody.getIdRole());
			}

			if (associationRolePrivilegeBody.getIdPrivilege() != 0) {
				associationRolePrivilegeUrl.setIdPrivilege(associationRolePrivilegeBody.getIdPrivilege());
			}

			return associationRolePrivilegeUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/associationroleprivilege/{id}")
	public void deleteAssociationRolePrivilege(@PathVariable("id") final Long id) {
		associationRolePrivilegeService.deleteAssociationRolePrivilege(id);
	}

}
