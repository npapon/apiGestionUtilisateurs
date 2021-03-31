package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "fichiers_utilisateur")
public class FichiersUtilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "id_utilisateur")
	@JsonIgnore
	private long idUtilisateur;

	private String type;

	private String emplacement;

}
