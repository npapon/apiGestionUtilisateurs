package fr.papounworld.apiGestionUtilisateurs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.papounworld.apiGestionUtilisateurs.model.Role;
import fr.papounworld.apiGestionUtilisateurs.model.Utilisateur;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
