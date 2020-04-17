package it.dstech.gestione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.dstech.modelli.Utente;

@WebServlet(urlPatterns = "/Accesso")
public class GestioneAccesso extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utente utente = new Utente((String ) req.getParameter("username"), (String) req.getParameter("password"));
		System.out.println(utente);
		String scelta = req.getParameter("scelta");
		System.out.println(scelta);
		
				GestioneBattleground gestione=new GestioneBattleground();
				if (scelta.equalsIgnoreCase("Log In")) {
					if (utente.getUsername().equalsIgnoreCase("") || utente.getPassword().equalsIgnoreCase("")){
						req.setAttribute("messaggio", "Inserisci i tuoi dati per accedere");
						req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
					} else if (utente.getUsername().equalsIgnoreCase("Admin")) {
						req.getRequestDispatcher("/ProfiloAdmin.jsp").forward(req, resp);
				    } else {
				    	if(gestione.creazioneUtente(utente) && utente.isActive()) {
				    		req.getRequestDispatcher("/ProfiloUtente.jsp").forward(req, resp);
				    	} else if(!utente.isActive()) {
				    		req.setAttribute("messaggio", "Per effettuare l'accesso attiva il tuo account cliccando sul link dell'email che ti abbiamo inviato.");
							req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
				    	} else if(!gestione.creazioneUtente(utente)) {
				    		req.setAttribute("messaggio", "Per effettuare l'accesso devi prima registrare un account.");
							req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
				    	}
				    }
				} else {
					req.getRequestDispatcher("/Registrazione.jsp").forward(req, resp);
				}
	}
}
