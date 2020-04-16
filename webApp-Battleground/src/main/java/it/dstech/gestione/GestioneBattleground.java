
package it.dstech.gestione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import it.dstech.modelli.Eroe;
import it.dstech.modelli.Partita;
import it.dstech.modelli.Utente;

public class GestioneBattleground {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
	private static  EntityManager em = emf.createEntityManager();

	public static void creazioneUtente(Utente u) {
        
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }
	
	public static void creazioneEroe(Eroe e) {
	       
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }
	
	public static void creazionePartita(Partita p) {
	       
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
	
	
}