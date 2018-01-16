package com.loncoto.loncontoBoot.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"batiments", "clients"})
public class Site {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="site")
	@JsonIgnore 
	private Set<Batiment> batiments;
	@ManyToMany
	@JsonIgnore
	private Set<Client> clients;
	
	public Set<Client> getClients(){
		if (this.clients == null) this.clients = new HashSet<>();
		return this.clients;
	}
	
	
	public Set<Batiment> getBatiments(){
		if (this.batiments == null) this.batiments = new HashSet<>();
		return this.batiments;
	}
	
	public Site(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
