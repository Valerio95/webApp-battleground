package it.dstech.gestione;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
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
  public void creazioneEroe(Eroe e)throws NoResultException {
   if(!controlloEroe(e)) {
         
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
   	}
   }

private boolean controlloEroe(Eroe e) {
	String username = e.getNome();
    List<Eroe> listaEroi  =   em.createQuery("SELECT e FROM Eroe e WHERE e.nome = ?1", Eroe.class).setParameter(1,username).getResultList();    
    for(Eroe eroe: listaEroi) {
    if (eroe.getNome().equalsIgnoreCase(e.getNome())){
      return true;
    }
    }
	return false;
}
  
  public String getImageUtenteString(Utente utente) throws IOException, SQLException {
	  List<Utente> queryList  =   em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1, utente.getUsername()).getResultList();
	  Blob immagineBlob = null;
	  for(Utente u: queryList) {
		immagineBlob = u.getImage();
	  }
	   InputStream inputStream = immagineBlob.getBinaryStream();
	   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	   byte[] buffer = new byte[4096];
	   int bytesRead = -1;
	   while ((bytesRead = inputStream.read(buffer)) != -1) {
	    outputStream.write(buffer, 0, bytesRead);
	   }
	   byte[] imageBytes = outputStream.toByteArray();
	   String immagineString = Base64.getEncoder().encodeToString(imageBytes);
	  return immagineString;
  }
  
  public String getImageEroeString(Eroe eroe) throws IOException, SQLException {
	  List<Eroe> queryList  =   em.createQuery("SELECT e FROM Eroe e WHERE e.nome = ?1", Eroe.class).setParameter(1, eroe.getNome()).getResultList();
	  Blob immagineBlob = null;
	  for(Eroe e: queryList) {
		immagineBlob = e.getImage();
	  }
	   InputStream inputStream = immagineBlob.getBinaryStream();
	   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	   byte[] buffer = new byte[4096];
	   int bytesRead = -1;
	   while ((bytesRead = inputStream.read(buffer)) != -1) {
	    outputStream.write(buffer, 0, bytesRead);
	   }
	   byte[] imageBytes = outputStream.toByteArray();
	   String immagineString = Base64.getEncoder().encodeToString(imageBytes);
	  return immagineString;
  }
  
  public void creazionePartita(Partita p) {
         
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

  public void rimuoviEroe() {
	  em.createQuery("SELECT e FROM Eroe e ", Eroe.class);
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
  
  
  public void validaUtente(Utente u) {

        Query query = em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1, u.getUsername());
        
        Utente utente = (Utente) query.getSingleResult();
        em.getTransaction().begin();
        utente.setActive(true);
        em.getTransaction().commit();

    }

  public boolean attivazioneUtente(Utente u) {
    Query query = em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1, u.getUsername());
        Utente utente = (Utente) query.getSingleResult();
    return utente.isActive();
  }
}