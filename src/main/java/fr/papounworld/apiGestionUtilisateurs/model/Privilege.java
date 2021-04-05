package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "privilege")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String libelle;

	private String impact;

	/*
	 * @OneToOne
	 * 
	 * @JoinTable(name = "association_roles_privileges", joinColumns
	 * = @JoinColumn(name = "id_privilege"), inverseJoinColumns = @JoinColumn(name =
	 * "id_role"))
	 * 
	 * private Role role;
	 */

}
