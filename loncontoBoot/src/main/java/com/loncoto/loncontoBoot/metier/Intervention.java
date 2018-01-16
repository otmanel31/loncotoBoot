package com.loncoto.loncontoBoot.metier;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude= {"equipment","intervenant"})
public class Intervention {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String singleInterventionNumber;
	private LocalDateTime interventionDate;
	private LocalDateTime dateOfCompletion;
	private String status;
	private String comment;
	@ManyToOne
	private Materiel equipment;
	@ManyToOne
	private Intervenant intervenant;
	
	public Intervention(int id, String singleInterventionNumber, LocalDateTime interventionDate,
			LocalDateTime dateOfCompletion, String status, String comment) {
		this.id = id;
		this.singleInterventionNumber = singleInterventionNumber;
		this.interventionDate = interventionDate;
		this.dateOfCompletion = dateOfCompletion;
		this.status = status;
		this.comment = comment;
	}
}
