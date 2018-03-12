package com.loncoto.loncontoBoot.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Groupe {
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany
	@JsonIgnore
	private Set<Intervenant> intervenants;
	
	public Set<Intervenant> getIntervenants(){
		if (this.intervenants == null) this.intervenants = new HashSet<>();
		return this.intervenants;
	}

	public Groupe(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
