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

import fr.papounworld.apiGestionUtilisateurs.model.Role;
import fr.papounworld.apiGestionUtilisateurs.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/role")
	public Iterable<Role> getRoles() {
		return roleService.getRoles();
	}

	@GetMapping("/role/{id}")
	public Role getRole(@PathVariable("id") final Long id) {
		Optional<Role> role = roleService.getRole(id);
		if (role.isPresent()) {
			return role.get();
		} else {
			return null;
		}
	}

	@PostMapping("/role")
	public Role createRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	@PutMapping("/role/{id}")
	public Role updateRole(@PathVariable("id") final Long id, @RequestBody Role roleBody) {

		Optional<Role> optionalRoleUrl = roleService.getRole(id);
		if (optionalRoleUrl.isPresent()) {
			Role roleUrl = optionalRoleUrl.get();
			if (roleBody.getLibelle() != null) {
				roleUrl.setLibelle(roleBody.getLibelle());
			}

			roleService.saveRole(roleUrl);
			return roleUrl;
		} else {

			return null;
		}
	}

	@DeleteMapping("/role/{id}")
	public void deleteRole(@PathVariable("id") final Long id) {
		roleService.deleteRole(id);
	}

}
