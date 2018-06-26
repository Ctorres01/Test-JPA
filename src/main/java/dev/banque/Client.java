package dev.banque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	
	
	public Client() {
		super();
		this.comptes = new ArrayList<>();
	}


	public Client(String nom, String prenom, LocalDate dateNaissance, Banque banque, Adresse adresse) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.banque = banque;
		this.adresse = adresse;
	}


	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="nom", length=30, nullable=false)
	private String nom;
	
	@Column(name="prenom", length=30, nullable=false)
	private String prenom;
	
	@Column(name="dateNaissance", length=30, nullable=false)
	private LocalDate dateNaissance;
	
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="compo",
	joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName="ID"))
	private List<Compte> comptes;
	
	
	@Embedded
	private Adresse adresse;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Banque getBanque() {
		return banque;
	}


	public void setBanque(Banque banque) {
		this.banque = banque;
	}


	public List<Compte> getComptes() {
		return comptes;
	}


	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
