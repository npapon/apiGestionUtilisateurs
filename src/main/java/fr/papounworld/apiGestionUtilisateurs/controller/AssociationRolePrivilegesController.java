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

import fr.papounworld.apiGestionUtilisateurs.model.AssociationRolePrivileges;
import fr.papounworld.apiGestionUtilisateurs.service.AssociationRolePrivilegesService;

@RestController
public class AssociationRolePrivilegesController {

	@Autowired
	private AssociationRolePrivilegesService associationRolePrivilegeService;

	@GetMapping("/associationroleprivileges")
	public Iterable<AssociationRolePrivileges> getAssociationRolePrivileges() {
		return associationRolePrivilegeService.getAssociationRolePrivileges();
	}

	@GetMapping("/associationroleprivileges/{id}")
	public AssociationRolePrivileges getAssociationRolePrivilege(@PathVariable("id") final Long id) {
		Optional<AssociationRolePrivileges> associationRolePrivilege = associationRolePrivilegeService
				.getAssociationRolePrivilege(id);
		if (associationRolePrivilege.isPresent()) {
			return associationRolePrivilege.get();
		} else {
			return null;
		}
	}

	@PostMapping("/associationroleprivileges")
	public AssociationRolePrivileges createAssociationRolePrivilege(
			@RequestBody AssociationRolePrivileges associationRolePrivilege) {
		return associationRolePrivilegeService.saveAssociationRolePrivilege(associationRolePrivilege);
	}

	@PutMapping("/associationroleprivileges/{id}")
	public AssociationRolePrivileges updateAssociationRolePrivilege(@PathVariable("id") final Long id,
			@RequestBody AssociationRolePrivileges associationRolePrivilegeBody) {

		Optional<AssociationRolePrivileges> optionalAssociationRolePrivilegeUrl = associationRolePrivilegeService
				.getAssociationRolePrivilege(id);
		if (optionalAssociationRolePrivilegeUrl.isPresent()) {
			AssociationRolePrivileges associationRolePrivilegeUrl = optionalAssociationRolePrivilegeUrl.get();

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

	@DeleteMapping("/associationroleprivileges/{id}")
	public void deleteAssociationRolePrivilege(@PathVariable("id") final Long id) {
		associationRolePrivilegeService.deleteAssociationRolePrivilege(id);
	}

}
