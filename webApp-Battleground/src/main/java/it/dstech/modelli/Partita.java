
package it.dstech.modelli;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String eroeScelto;  
	private String composizione;  
	private int  posizioneFinale;  
	private String note;  
    private int rating;
	
    public Partita() {
	}

	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEroeScelto() {
		return eroeScelto;
	}



	public void setEroeScelto(String eroeScelto) {
		this.eroeScelto = eroeScelto;
	}



	public String getComposizione() {
		return composizione;
	}



	public void setComposizione(String composizione) {
		this.composizione = composizione;
	}



	public int getPosizioneFinale() {
		return posizioneFinale;
	}



	public void setPosizioneFinale(int posizioneFinale) {
		this.posizioneFinale = posizioneFinale;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}
	
	
}
