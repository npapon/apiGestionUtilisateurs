package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("2")
public class ActionApplicativeScript extends ActionApplicative {

	private String crud;
}
