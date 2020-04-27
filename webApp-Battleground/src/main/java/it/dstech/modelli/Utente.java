package it.dstech.modelli;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Utente {
  
    @Id
    private String username;
    private String password;
    private boolean active;
    private int ratingIniziale;
    @Lob
    @Column(columnDefinition ="LONGBLOB NOT NULL")
    private Blob image;
      
    @OneToMany(mappedBy = "utente")
    List<Partita> storicoPartite = new ArrayList<Partita>();
     
    private int ratingFinale;
    
    
    public Utente() {
    }
    
    public Utente(String username, String password) {
      this.username = username;
      this.password = password;
    }

    public Utente(String username, String password, boolean active, int rating, Blob image) {
      super();
      this.username = username;
      this.password = password;
      this.active = active;
      this.ratingIniziale = rating;
      this.image = image;
    }

    

	public int getRatingIniziale() {
		return ratingIniziale;
	}

	public void setRatingIniziale(int ratingIniziale) {
		this.ratingIniziale = ratingIniziale;
	}

	public int getRatingFinale() {
		return ratingFinale;
	}

	public void setRatingFinale(int ratingFinale) {
		this.ratingFinale = ratingFinale;
	}

	public List<Partita> getStoricoPartite() {
		return storicoPartite;
	}

	public void setStoricoPartite(List<Partita> storicoPartite) {
		this.storicoPartite = storicoPartite;
	}

	public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public boolean isActive() {
      return active;
    }

    public void setActive(boolean active) {
      this.active = active;
    }

   

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Utente [username=" + username + ", password=" + password + ", active=" + active + ", rating=" + ratingIniziale
				+ ", image=" + image + ",  storicoPartite=" + storicoPartite + "]";
	}      
}