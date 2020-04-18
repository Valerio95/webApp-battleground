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
		String scelta = req.getParameter("scelta");
		
				GestioneBattleground gestione=new GestioneBattleground();
				if (scelta.equalsIgnoreCase("Log In")) {
					if (utente.getUsername().equalsIgnoreCase("") || utente.getPassword().equalsIgnoreCase("")){
						req.setAttribute("messaggio", "Inserisci i tuoi dati per accedere");
						req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
					} else if (utente.getUsername().equalsIgnoreCase("Admin") && utente.getPassword().equalsIgnoreCase("123")) {
						req.getRequestDispatcher("/ProfiloAdmin.jsp").forward(req, resp);
				    } else {
				    	boolean creazioneUtente= gestione.creazioneUtente(utente);
				    	if(creazioneUtente && utente.isActive()) {
				    		req.getRequestDispatcher("/ProfiloUtente.jsp").forward(req, resp);
				    	} else if(!utente.isActive()&&creazioneUtente ) {
				    		req.setAttribute("messaggio", "Per effettuare l'accesso attiva il tuo account cliccando sul link dell'email che ti abbiamo inviato.");
							req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
				    	} else if(!creazioneUtente) {
				    		req.setAttribute("messaggio", "Per effettuare l'accesso devi prima registrare un account.");
							req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
				    	}
				    }
				} else {
					req.getRequestDispatcher("/Registrazione.jsp").forward(req, resp);
				}
	}
	
	private String scriviRispostaUtenteNonAttivo(Utente utente) {
		String mailUtente = utente.getUsername();
		int indexOf = mailUtente.indexOf('@');
		String parteFinaleMail = mailUtente.substring(indexOf);
		String primiDueCaratteri = mailUtente.substring(0, 3);
		String mailFinale = primiDueCaratteri + contaX(indexOf - 2) + parteFinaleMail;
		return "L'utente " + mailFinale + " non ha ancora validato l'email";
	}

	
	
	private String contaX(int numeri) {
		String x = "";
		for (int i = 0; i < numeri; i++) {
			x += "x";
		}
		return x;
	}
	
	private String generaLinkValidazioneUtente(Utente utente) {
		String validationPath = "http://localhost:8080/webApp-libreria/validazione?utente=";
		return "Per attivare la mail clicca su questo link: " + validationPath + utente.getUsername();
	}
}
