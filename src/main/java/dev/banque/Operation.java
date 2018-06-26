package dev.banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	
	public Operation() {
		super();
	}
	
	
	public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
		this();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	@Id
	@GeneratedValue
	protected int id;
	
	@Column(name="DATE", length=30, nullable = true)
	protected LocalDateTime date;
	
	@Column(name="MONTANT", length=30, nullable = false)
	protected double montant;
	
	@Column(name="MOTIF", length=30, nullable=true)
	protected String motif;
	
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	protected Compte compte;
}
