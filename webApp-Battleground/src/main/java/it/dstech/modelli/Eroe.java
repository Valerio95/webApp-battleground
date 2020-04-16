package it.dstech.modelli;

import java.sql.Blob;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Eroe {
	
	@Id
	private String nome;
	private Blob image;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany
	private List<Utente> utenti;
	
	public String getUsername() {
		return nome;
	}

	public void setUsername(String username) {
		this.nome = username;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Utente> getLibri() {
		return utenti;
	}
	

	public void setLibri(List<Utente> libri) {
		this.utenti = libri;
	}

	public Eroe() {
	}
}
