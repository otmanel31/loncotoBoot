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
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"etages"})
public class Batiment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Site site;
	@OneToMany(mappedBy="batiment")
	@JsonIgnore
	private Set<Etage> etages;
	
	public Set<Etage> getEtages(){
		if (this.etages == null ) this.etages = new HashSet<>();
		return this.etages;
	}
	
	public Batiment(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
