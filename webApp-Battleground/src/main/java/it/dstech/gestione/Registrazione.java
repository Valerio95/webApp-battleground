package it.dstech.gestione;

import java.io.IOException;
import java.sql.Blob;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.dstech.modelli.Utente;
import it.dstech.utility.EmailUtility;


@WebServlet(urlPatterns = "/Registrati")
public class Registrazione extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Blob imagePart =(Blob) req.getPart("image");
		Utente u = new Utente();
		u.setPassword(password);
		u.setUsername(username);
		u.setImage(imagePart);
		try {
			GestioneBattleground	gestioneB = new GestioneBattleground();
			boolean aggiungiUtente= gestioneB.creazioneUtente(u);
			if(aggiungiUtente) {
			EmailUtility.sendEmail(u.getUsername(), "Conferma Mail", generaLinkValidazioneUtente(u));
			gestioneB.close();
			req.setAttribute("messaggio", "Controlla la mail per attivare l'account");
			req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);

			}else {
				gestioneB.close();
				req.setAttribute("messaggio", "Mail già presente nel DB");
				req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
			}
		} catch ( MessagingException e) {
			
			
			e.printStackTrace();

		}
	}
	

		

	
		
	private String generaLinkValidazioneUtente(Utente utente) {
		String validationPath = "http://localhost:8080/webApp-libreria/validazione?utente=";
		return "Per attivare la mail clicca su questo link: " + validationPath + utente.getUsername();
	}

}
