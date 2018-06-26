package dev.banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	
	public Virement() {
		super();
	}
	
	public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	
	@Column(name="BENEFICIAIRE", length=30, nullable=false)
	private String beneficiaire;

}
