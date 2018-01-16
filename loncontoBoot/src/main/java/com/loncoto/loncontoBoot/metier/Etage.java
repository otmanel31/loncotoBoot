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
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"batiment", "salles"})
public class Etage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int number;
	@ManyToOne
	private Batiment batiment;
	@OneToMany(mappedBy="etage")
	@JsonIgnore
	private Set<Salle> salles;
	
	public Set<Salle> getSalles(){
		if (this.salles == null ) this.salles = new HashSet<>();
		return this.salles;
	}
	
	public Etage(int id, int number) {
		this.id = id;
		this.number = number;
	}
}
