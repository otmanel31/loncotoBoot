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
@Getter  @Setter @NoArgsConstructor @ToString(exclude= {"family", "articles"})
public class SousFamille {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	private Famille family;
	@OneToMany(mappedBy="subfamilly")
	@JsonIgnore
	private Set<Article> articles;
	
	public Set<Article> getArticles(){
		if (this.articles == null) this.articles = new HashSet<>();
		return this.articles;
	}

	public SousFamille(int id, String name, Famille family) {
		super();
		this.id = id;
		this.name = name;
		this.family = family;
	}
	
}
