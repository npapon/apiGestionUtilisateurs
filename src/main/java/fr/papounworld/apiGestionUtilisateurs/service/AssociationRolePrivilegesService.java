package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.AssociationRolePrivileges;
import fr.papounworld.apiGestionUtilisateurs.repository.AssociationRolePrivilegesRepository;
import lombok.Data;

@Data
@Service
public class AssociationRolePrivilegesService {

	@Autowired
	private AssociationRolePrivilegesRepository associationRolePrivilegeRepository;

	public Iterable<AssociationRolePrivileges> getAssociationRolePrivileges() {
		return associationRolePrivilegeRepository.findAll();
	}

	public Optional<AssociationRolePrivileges> getAssociationRolePrivilege(final Long id) {
		return associationRolePrivilegeRepository.findById(id);

	}

	public void deleteAssociationRolePrivilege(final long id) {

		associationRolePrivilegeRepository.deleteById(id);
	}

	public AssociationRolePrivileges saveAssociationRolePrivilege(AssociationRolePrivileges AssociationRolePrivilege) {

		associationRolePrivilegeRepository.save(AssociationRolePrivilege);
		return AssociationRolePrivilege;

	}

}
