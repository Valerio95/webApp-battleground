package it.dstech.gestione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Composizione;
import it.dstech.modelli.Eroe;
import it.dstech.modelli.Partita;
import it.dstech.modelli.Utente;

@WebServlet(urlPatterns = "/CreazionePartita")
public class CreazionePartita extends HttpServlet{
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  HttpSession session = req.getSession();
		  GestioneBattleground gestione = new GestioneBattleground();
		  
		  
	    Partita partita= new Partita();
	    partita.setComposizione((String)req.getParameter("composizione"));
        partita.setEroeScelto((String)req.getParameter("eroe"));
        partita.setNote(req.getParameter("note"));
        partita.setPosizioneFinale(Integer.parseInt(req.getParameter("PosizioneFinale")));
        partita.setRating(Integer.parseInt(req.getParameter("rating")));
	
        
        Utente utente =(Utente) session.getAttribute("utente");
        partita.setUtente(utente);
        utente.getStoricoPartite().add(partita);
        
	         
	   
	   
	    gestione.creazionePartita(partita,utente);
	    List<Composizione> listaComposizioni =	gestione.stampaComposizioni();
        List<Eroe> listaEroi =	gestione.stampaEroi();
        List<Partita> listaPartite =	gestione.stampaPartite();
        session.setAttribute("partita", partita); 
        req.setAttribute("listaComposizioni", listaComposizioni);
        req.setAttribute("listaEroi", listaEroi);
        req.setAttribute("listaPartite", listaPartite);

	    
	    req.getRequestDispatcher("/CreaPartita.jsp").forward(req, resp);
	  }

}
