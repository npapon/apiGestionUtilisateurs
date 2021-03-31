package fr.papounworld.apiGestionUtilisateurs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String libelle;

	/*
	 * On efface le one to one role privilege pour un one to many
	 * 
	 * @OneToOne
	 * 
	 * @JoinTable(name = "association_roles_privileges", joinColumns
	 * = @JoinColumn(name = "id_role"), inverseJoinColumns = @JoinColumn(name =
	 * "id_privilege"))
	 */

	@OneToMany
	@JoinTable(name = "association_roles_privileges", joinColumns = @JoinColumn(name = "id_role"), inverseJoinColumns = @JoinColumn(name = "id_privilege"))
	private List<Privilege> privileges = new ArrayList<Privilege>();

}
