package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "action_applicative_extraction")
@PrimaryKeyJoinColumn(name = "id_action_applicative")
public class ActionApplicativeExtraction extends ActionApplicative {

	@Column(name = "format_sortie")
	private String formatSortie;

}
