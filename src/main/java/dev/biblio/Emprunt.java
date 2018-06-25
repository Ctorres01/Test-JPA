package dev.biblio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	@Id
	private long id;
	
	@Column(name = "date_debut", length = 30, nullable = false)
	private LocalDate beginningDate;
	
	@Column(name = "date_fin", length = 30, nullable = true)
	private LocalDate endDate;
	
	@Column(name = "delai", length = 30, nullable = true)
	private int delay;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="compo",
		joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private List<Livre> livres;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getBeginningDate() {
		return beginningDate;
	}
	
	public void setBeginningDate(LocalDate beginningDate) {
		this.beginningDate = beginningDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public Client getClientId() {
		return client;
	}

	public void setClientId(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	
	
	
}
