package dev.biblio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="CLIENT")
public class Client {
	@Id
	private long Id;
	
	@Column(name = "nom", length = 30, nullable = false, unique = true)
	private String lastName;
	
	@Column(name = "prenom", length = 30, nullable = false, unique = true)
	private String firstName;

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
