package it.dstech.modelli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Utente {
		
		private String username;
		private String password;
		private boolean active = false;
		private int rating = 0;
		private byte[] image;
		
		List<Eroe> listaEroe = new ArrayList<Eroe>();
		List<Partita> storicoPartite = new ArrayList<Partita>();
		
		
		public Utente(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public void creaPartita(){
			
		}
		
		public Utente(String username, String password, boolean active, byte[] image) {
			super();
			this.username = username;
			this.password = password;
			this.active = active;
			this.image = image;
		}
		
		public Utente() {
			super();
		}

		public Utente(String username, String password, boolean active) {
			super();
			this.username = username;
			this.password = password;
			this.active = active;
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
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}

		@Override
		public String toString() {
			return "Utente [username=" + username + ", password=" + password + ", active=" + active + ", image="
					+ Arrays.toString(image) + "]";
		}
		
}