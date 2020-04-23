package it.dstech.modelli;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;


@Entity
public class Eroe {
	
	@Id
	private String nome;
	@Lob
	@Column(columnDefinition ="LONGBLOB NOT NULL")
    private Blob image;
	private String potere;
	private int costo;
	private int HP;
	@OneToMany
	private List<Utente> utenti;
	
	
	
	
	
	public Eroe(String nome, String potere) {
		super();
		this.nome = nome;
		this.potere = potere;
	}

	public Eroe(String nome, String potere, int costo, int hP) {
		super();
		this.nome = nome;
		this.potere = potere;
		this.costo = costo;
		HP = hP;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

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

	@Override
	public String toString() {
		return "Eroe [nome=" + nome + ", image=" + image + ", potere=" + potere + ", costo=" + costo + ", HP=" + HP
				+ ", utenti=" + utenti + "]";
	}
	
}
