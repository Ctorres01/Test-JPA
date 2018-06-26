package dev.banque;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	public Adresse() {
		super();
	}
	
	

	public Adresse(int numero, String rue, int codePostal, String ville) {
		this();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	@Column(name="numero", length=5, nullable=true)
	private int numero;
	
	@Column(name="rue", length=50, nullable=false)
	private String rue;
	
	@Column(name="codePostal", length=5, nullable=false)
	private int codePostal;
	
	@Column(name="ville", length=30, nullable=false)
	private String ville;

	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getRue() {
		return rue;
	}



	public void setRue(String rue) {
		this.rue = rue;
	}



	public int getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
