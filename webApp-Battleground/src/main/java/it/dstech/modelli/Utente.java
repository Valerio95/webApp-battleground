package it.dstech.modelli;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
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
		private int rating = 0;
		@Lob
		private Blob image;
		
		@OneToMany
		List<Eroe> listaEroe = new ArrayList<Eroe>();
		
		@OneToMany
		List<Partita> storicoPartite = new ArrayList<Partita>();
		
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
			this.rating = rating;
			this.image = image;
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

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public Blob getImage() {
			return image;
		}

		public void setImage(Blob image) {
			this.image = image;
		}

		@Override
		public String toString() {
			return "Utente [username=" + username + ", password=" + password + ", active=" + active + ", rating="
					+ rating + "]";
		}			
}