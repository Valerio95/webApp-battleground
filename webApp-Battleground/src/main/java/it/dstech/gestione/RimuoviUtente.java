package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Utente;

public class RimuoviUtente extends HttpServlet{
	  private static final long serialVersionUID = 1L;

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }
	  
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  HttpSession session = req.getSession();
		  Utente utente =  (Utente) session.getAttribute("utente");
		  String scelta =(String) req.getAttribute("scelta");
		  if (scelta.equalsIgnoreCase("si")) {
		  GestioneBattleground gestione = new GestioneBattleground();
		  gestione.rimuoviUtente(utente.getUsername());
		  req.setAttribute("messaggio", "rimozione avvenuta con successo");
		  req.getRequestDispatcher("/RimuoviUtente.jsp").forward(req, resp);
		  }
	  }

}
