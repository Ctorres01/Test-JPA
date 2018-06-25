package dev.biblio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="CLIENT")
public class Client {
	@Id
	private long Id;
	
	@Column(name = "nom", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "prenom", length = 30, nullable = false)
	private String firstName;
	
	@OneToMany(mappedBy="client")
	private List<Emprunt> emprunts;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
