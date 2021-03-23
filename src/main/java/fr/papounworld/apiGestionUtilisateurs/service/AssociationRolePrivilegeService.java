package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.AssociationRolePrivilege;
import fr.papounworld.apiGestionUtilisateurs.repository.AssociationRolePrivilegeRepository;
import lombok.Data;

@Data
@Service
public class AssociationRolePrivilegeService {

	@Autowired
	private AssociationRolePrivilegeRepository associationRolePrivilegeRepository;

	public Iterable<AssociationRolePrivilege> getAssociationRolePrivileges() {
		return associationRolePrivilegeRepository.findAll();
	}

	public Optional<AssociationRolePrivilege> getAssociationRolePrivilege(final Long id) {
		return associationRolePrivilegeRepository.findById(id);

	}

	public void deleteAssociationRolePrivilege(final long id) {

		associationRolePrivilegeRepository.deleteById(id);
	}

	public AssociationRolePrivilege saveAssociationRolePrivilege(AssociationRolePrivilege AssociationRolePrivilege) {

		associationRolePrivilegeRepository.save(AssociationRolePrivilege);
		return AssociationRolePrivilege;

	}

}
