package fr.papounworld.apiGestionUtilisateurs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.papounworld.apiGestionUtilisateurs.model.Role;
import fr.papounworld.apiGestionUtilisateurs.repository.RoleRepository;
import lombok.Data;

@Data
@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Iterable<Role> getRoles() {
		return roleRepository.findAll();
	}

	public Optional<Role> getRole(final Long id) {
		return roleRepository.findById(id);

	}

	public void deleteRole(final long id) {

		roleRepository.deleteById(id);
	}

	public Role saveRole(Role role) {

		roleRepository.save(role);
		return role;

	}

}
