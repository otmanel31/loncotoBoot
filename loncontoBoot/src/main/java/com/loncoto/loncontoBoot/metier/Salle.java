package com.loncoto.loncontoBoot.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"equipments"})
public class Salle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToOne
	private Etage etage;
	@OneToMany(mappedBy="salle")
	@JsonIgnore
	private Set<Materiel> equipments;
	
	public Salle(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Set<Materiel> getEquipments(){
		if (this.equipments == null) this.equipments = new HashSet<>();
		return this.equipments;
	}
	
}
