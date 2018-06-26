package dev.banque;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	
	
	
	public LivretA() {
		super();
	}
	
	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}


	@Column(name="taux", nullable=false)
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	
	
}
