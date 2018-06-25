package dev.biblio;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Livre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "titre", length = 30, nullable = false)
	private String title;

	@Column(name = "auteur", length = 30, nullable = false)
	private String author;
	
	@ManyToMany
	@JoinTable(name="compo",
		joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID")
	)
	private List<Emprunt> emprunts; 
	
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
