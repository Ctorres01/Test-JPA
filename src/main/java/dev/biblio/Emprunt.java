package dev.biblio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	@Id
	private long id;
	
	@Column(name = "date_debut", length = 30, nullable = false, unique = true)
	private LocalDate beginningDate;
	
	@Column(name = "date_fin", length = 30, nullable = false, unique = true)
	private LocalDate endDate;
	
	@Column(name = "delai", length = 30, nullable = false, unique = true)
	private int delay;
	
	@Column(name = "id_client", length = 30, nullable = false, unique = true)
	private long clientId;

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

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	
}
