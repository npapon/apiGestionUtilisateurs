package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "association_roles_utilisateur")
public class AssociationRolesUtilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "id_role")
	private int idRole;

	@Column(name = "id_utilisateur")
	private int idUtilisateur;

}
