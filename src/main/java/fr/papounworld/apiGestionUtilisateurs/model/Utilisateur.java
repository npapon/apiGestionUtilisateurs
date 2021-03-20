package fr.papounworld.apiGestionUtilisateurs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name ="utilisateurs")
public class Utilisateur {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    private String login ;    

    private String motdepasse ;
    
    @OneToOne( cascade = CascadeType.ALL ) 
    @JoinColumn( name="id_informations_personnelles_utilisateur",referencedColumnName = "id" )
    private InformationsPersonnellesUtilisateur  informationsPersonnellesUtilisateur;




}

