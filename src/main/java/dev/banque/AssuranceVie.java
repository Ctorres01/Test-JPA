package dev.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	
	public AssuranceVie() {
		super();
	}
	
	public AssuranceVie(String numero, double solde, double taux, LocalDate dateFin) {
		super(numero, solde);
		this.taux = taux;
		this.dateFin = dateFin;
	}

	
	@Column(name="TAUX", nullable = false)
	private double taux;
	
	@Column(name="DATE_FIN", nullable = true)
	private LocalDate dateFin;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	
}
