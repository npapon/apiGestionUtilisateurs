package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "action_applicative")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ActionApplicative {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String libelle;

}
