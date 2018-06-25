package dev.biblio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Livre {
	@Id
	private long id;
	
	@Column(name = "titre", length = 30, nullable = false, unique = true)
	private String title;

	@Column(name = "auteur", length = 30, nullable = false, unique = true)
	private String author;
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
