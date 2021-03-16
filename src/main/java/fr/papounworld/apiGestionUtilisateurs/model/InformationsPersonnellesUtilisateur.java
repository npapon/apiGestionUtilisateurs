package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="informations_personnelles_utilisateur")
public class InformationsPersonnellesUtilisateur {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String adresse;
    private String telephone;
    
    @OneToOne( cascade = CascadeType.ALL ) 
    @JoinColumn( name="id_utilisateur",referencedColumnName = "id" )
    private Utilisateur utilisateur;

     

}
