package com.loncoto.loncontoBoot.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude= {"article", "interventions", "client", "salle"})
public class Materiel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String serialNumber;
	@OneToMany(mappedBy="equipment")
	@JsonIgnore
	private Set<Intervention> interventions;
	@ManyToOne
	private Article article;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Salle salle;
	
	public Set<Intervention> getInterventions(){
		if (this.interventions == null) this.interventions = new HashSet<>();
		return this.interventions;
	}
	
	public Materiel(int id, String serialNumber) {
		this.id = id;
		this.serialNumber = serialNumber;
	}
	
}
