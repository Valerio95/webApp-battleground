package it.dstech.modelli;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Eroe {
	
	@Id
	private String nome;
	private Blob image;
	private String potere;
	private int costo;

	
	@OneToMany
	private List<Utente> utenti;
	
	public String getNome() {
		return nome;
	}

	public String getPotere() {
		return potere;
	}

	public void setPotere(String potere) {
		this.potere = potere;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
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
