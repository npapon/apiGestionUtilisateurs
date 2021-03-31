package fr.papounworld.apiGestionUtilisateurs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "actions_utilisateur")
public class ActionsUtilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String action;

	@Column(name = "action_date")
	private Date actionDate;

	@ManyToOne
	@JoinTable(name = "association_actions_utilisateur", joinColumns = @JoinColumn(name = "id_action"), inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
	private Utilisateur utilisateur;

}
