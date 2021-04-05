package fr.papounworld.apiGestionUtilisateurs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "connexion_utilisateur")
public class ConnexionUtilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id", nullable = false)
	private Utilisateur utilisateur;

	@Column(name = "connexion_date")
	private Date connexionDate;

}
