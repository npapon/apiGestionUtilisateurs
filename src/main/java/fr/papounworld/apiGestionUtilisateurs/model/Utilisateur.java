package fr.papounworld.apiGestionUtilisateurs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String login;

	private String motdepasse;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_information_personnelle_utilisateur", referencedColumnName = "id", nullable = false)
	private InformationPersonnelleUtilisateur informationPersonnelleUtilisateur;

	@OneToMany(targetEntity = FichierUtilisateur.class, mappedBy = "idUtilisateur", fetch = FetchType.EAGER)
	private List<FichierUtilisateur> fichiers = new ArrayList<>();

	/*
	 * @ManyToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "association_utilisateurs_recompenses", joinColumns
	 * = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name
	 * = "id_recompense")) private Set<Recompense> recompenses = new HashSet<>();
	 * 
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@MapKey(name = "id")
	@JoinTable(name = "association_utilisateurs_recompenses", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "id_recompense"))
	private Map<Integer, Recompense> recompenses = new HashMap<>();

}
