package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "action_applicative_script")
/*
 * @PrimaryKeyJoinColumn(name = "id_action_applicative")
 */
public class ActionApplicativeScript extends ActionApplicative {

	private String crud;
}
