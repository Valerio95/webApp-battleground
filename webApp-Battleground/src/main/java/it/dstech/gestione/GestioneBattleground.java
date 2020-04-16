
package it.dstech.gestione;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.dstech.modelli.Eroe;
import it.dstech.modelli.Partita;
import it.dstech.modelli.Utente;

public class GestioneBattleground {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
	private static  EntityManager em = emf.createEntityManager();

	public  boolean creazioneUtente(Utente u) {
		Query getUtente =   em.createQuery("SELECT u FROM Utente u WHERE u.username = ? 1", Utente.class);
		 getUtente.setParameter(1, u.getUsername());
		 Utente utente =(Utente) getUtente.getSingleResult();
		if (utente.getUsername().equalsIgnoreCase(u.getUsername())){
			return false;
		}
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }
	public boolean creazioneEroe(Eroe e) {
		Query getEroe =   em.createQuery("SELECT e FROM Eroe e WHERE e.nome = ? 1", Eroe.class);
		 getEroe.setParameter(1, e.getNome());
		 Eroe eroe =(Eroe) getEroe.getSingleResult();
		if (eroe.getNome().equalsIgnoreCase(e.getNome())){
			return false;
		} 

	       
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        return true;
    }
	
	public void creazionePartita(Partita p) {
	       
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
	public List<Eroe> stampaEroi () {
		List<Eroe> listaEroi =   em.createQuery("SELECT e FROM Eroe e ", Eroe.class).getResultList();
		return listaEroi;
	}

	
	
}