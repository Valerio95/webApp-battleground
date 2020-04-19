package it.dstech.gestione;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.dstech.modelli.Composizione;
import it.dstech.modelli.Eroe;
import it.dstech.modelli.Partita;
import it.dstech.modelli.Utente;
import javax.servlet.http.HttpSession;
 
public class GestioneBattleground {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
	private static  EntityManager em = emf.createEntityManager();

	public boolean controlloUtente(Utente u) {
		String username = u.getUsername();
		List<Utente> listaUtenti  =  em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1,username).getResultList();		
		for(Utente utente: listaUtenti) {
		if (utente.getUsername().equalsIgnoreCase(u.getUsername())){
			return true;
		}
		}
		return false;
	}
	
	public  void creazioneUtente(Utente u)throws NoResultException {
		if(!controlloUtente(u)) {
			em.getTransaction().begin();
	        em.persist(u);
	        em.getTransaction().commit();  
		}
    }
	
	public void close() {
		em.close();
	}
	public boolean creazioneEroe(Eroe e) {
		String username = e.getNome();
		List<Eroe> listaEroi  =   em.createQuery("SELECT e FROM Eroe e WHERE e.nome = ?1", Eroe.class).setParameter(1,username).getResultList();		
		for(Eroe eroe: listaEroi) {
		if (eroe.getNome().equalsIgnoreCase(e.getNome())){
			return false;
		}
		}
	       
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }
	
	
	
	public void creazionePartita(Partita p) {
	       
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

	
	
	public List<Eroe> stampaEroi () {
		List<Eroe> listaEroi =   em.createQuery("SELECT e FROM Eroe e ", Eroe.class).getResultList();
		return listaEroi;
	}
	
	public List<Partita> stampaPartite () {
		List<Partita> listaPartite =   em.createQuery("SELECT p FROM Partita p ", Partita.class).getResultList();
		return listaPartite;
	}
	
	
	public List<Utente> stampaUtenti () {
		List<Utente> listaUtenti =   em.createQuery("SELECT u FROM Utente u ", Utente.class).getResultList();
		return listaUtenti;
	}
	

	public List<Composizione> stampaComposizioni () {
		List<Composizione> listaComposizioni =   em.createQuery("SELECT c FROM Composizione c ", Composizione.class).getResultList();
		return listaComposizioni;
	}
	
	public void aggiungiComposizione (String composizione) {
		em.getTransaction().begin();
        em.persist(composizione);
        em.getTransaction().commit();
		
	}
	
	public void validaUtente(Utente u) throws SQLException {
	 em.createQuery("UPDATE Utente SET active=?1 "+"WHERE username=?2").setParameter(1, true).setParameter(2, u.getUsername());
        
	
	}
	
}

