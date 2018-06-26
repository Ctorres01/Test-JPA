package dev.banque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="banque")
public class Banque {
	
	
	
	public Banque() {
		super();
		this.clients = new ArrayList<>();
	}

	public Banque(String nom) {
		this();
		this.nom = nom;
	}
	
	@Id
	@GeneratedValue
	private int Id;

	@Column(name="nom", length = 30, nullable = false)
	private String nom;
	
	@OneToMany(mappedBy="banque")
	private List<Client> clients;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
