package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("1")
public class ActionApplicativeExtraction extends ActionApplicative {

	@Column(name = "format_sortie")
	private String formatSortie;

}
