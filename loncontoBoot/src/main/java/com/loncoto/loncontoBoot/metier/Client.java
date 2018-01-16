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
@Getter  @Setter @NoArgsConstructor @ToString(exclude= {"equipments", "sites"})
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="client")
	@JsonIgnore
	private Set<Materiel> equipments;
	@ManyToMany(mappedBy="clients")
	@JsonIgnore
	private Set<Site> sites;
	
	public Set<Site> getSites(){
		if (this.sites == null ) this.sites = new HashSet<>();
		return this.sites;
	}
	
	public Client(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Set<Materiel> getEquipments(){
		if (this.equipments == null) this.equipments = new HashSet<>();
		return this.equipments;
	}
}
