package dev.banque;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="compte")
public class Compte {
	
	
	
	public Compte() {
		super();
		this.operations = new ArrayList<>();
		this.clients = new ArrayList<>();
	}

	public Compte(String numero, double solde) {
		this();
		this.numero = numero;
		this.solde = solde;
	}

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="NUMERO", length = 30, nullable=false)
	private String numero;
	
	@Column(name="SOLDE", length = 30, nullable=false)
	private double solde;
	
	@ManyToMany
	@JoinTable(name="compo",
	joinColumns= @JoinColumn(name="ID_COM", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"))
	private List<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private List<Operation> operations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
}
