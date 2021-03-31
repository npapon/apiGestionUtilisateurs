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
@Table(name = "association_utilisateurs_recompenses")
public class AssociationUtilisateursRecompenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "id_utilisateur")
	private int idUtilisateur;

	@Column(name = "id_recompense")
	private int idRecompense;

}
