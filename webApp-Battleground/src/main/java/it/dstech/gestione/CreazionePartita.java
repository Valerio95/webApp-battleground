package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Partita;

public class CreazionePartita extends HttpServlet{
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Partita partita= new Partita();
	    partita.setComposizione(req.getParameter("composizine"));
        partita.setEroeScelto(req.getParameter("eroe"));
        partita.setNote(req.getParameter("note"));
        partita.setRating(Integer.parseInt(req.getParameter("rating")));
	    HttpSession session = req.getSession();
	    session.setAttribute("partita", partita);    
	    GestioneBattleground gestione = new GestioneBattleground();
	    
	    gestione.creazionePartita(partita);
	    
	  }

}
