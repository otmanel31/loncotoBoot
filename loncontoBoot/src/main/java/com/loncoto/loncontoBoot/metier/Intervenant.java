package com.loncoto.loncontoBoot.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude= {"interventions"})
public class Intervenant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String lastname;
	private String firstname;
	@OneToMany(mappedBy="intervenant")
	@JsonIgnore
	private Set<Intervention> interventions;
	@ManyToMany(mappedBy="intervenants")
	@JsonIgnore
	private Set<Groupe> groups;
	
	public Set<Groupe> getGroups(){
		if (this.groups == null) this.groups = new HashSet<>();
		return this.groups;
	}
	
	public Set<Intervention> getInterventions(){
		if (this.interventions == null) this.interventions = new HashSet<>();
		return this.interventions;
	}

	public Intervenant(int id, String lastname, String firstname) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
}
