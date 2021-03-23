package fr.papounworld.apiGestionUtilisateurs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.papounworld.apiGestionUtilisateurs.model.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long>  {

}
