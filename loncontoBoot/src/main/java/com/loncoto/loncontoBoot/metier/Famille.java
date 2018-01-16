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
@Getter  @Setter @NoArgsConstructor @ToString(exclude= {"subfamilies"})
public class Famille {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="family")
	@JsonIgnore
	private Set<SousFamille> subfamilies;
	
	public Set<SousFamille> getSubfamilies(){
		if (this.subfamilies == null) this.subfamilies = new HashSet<>();
		return this.subfamilies;
	}

	public Famille(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
