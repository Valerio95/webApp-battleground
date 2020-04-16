package it.dstech.gestione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.dstech.modelli.Utente;


public class GestioneAccesso extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utente utente = new Utente((String ) req.getParameter("username"), (String) req.getParameter("password"));
		String scelta = req.getParameter("scelta");

			
			try {
				if (scelta.equalsIgnoreCase("Log In")) {
					if (utente.getUsername() == null){
						req.setAttribute("messaggio", "Inserisci la tua email come username per accedere");
						req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
					} else if (utente.getUsername().equalsIgnoreCase("Admin")) {
						req.getRequestDispatcher("/ProfiloAdmin.jsp").forward(req, resp);
				    } else {
				    	if(creazioneUtente(utente) && utente.isActive()) {
				    		req.getRequestDispatcher("/ProfiloUtente.jsp").forward(req, resp);
				    	} else if(!utente.isActive()) {
				    		req.setAttribute("messaggio", "Per effettuare l'accesso attiva il tuo account cliccando sul link dell'email che ti abbiamo inviato.");
							req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
				    	} else if(!creazioneUtente(utente)) {
				    		req.setAttribute("messaggio", "Per effettuare l'accesso devi prima registrare un account.");
							req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
				    	}
				    }
				} else {
					req.getRequestDispatcher("/Registrazione.jsp").forward(req, resp);
				}
			} catch (Exception e) {
			}
	}
}
