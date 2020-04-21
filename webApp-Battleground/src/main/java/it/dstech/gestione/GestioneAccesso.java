package it.dstech.gestione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Utente;

@WebServlet(urlPatterns = "/Accesso")
public class GestioneAccesso extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  HttpSession session =req.getSession();

	  Utente utente = new Utente( req.getParameter("username"),  req.getParameter("password"));
	  String scelta = req.getParameter("scelta");
	  session.setAttribute("utente", utente);
    
        GestioneBattleground gestione=new GestioneBattleground();
        if (scelta.equalsIgnoreCase("Log In")) {
          if (utente.getUsername().equalsIgnoreCase("") || utente.getPassword().equalsIgnoreCase("") || utente.getPassword()==null||utente.getUsername()==null){
            req.setAttribute("messaggio", "Credenziali errate o account non registrato");
            req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
          } else if (utente.getUsername().equalsIgnoreCase("Admin") && utente.getPassword().equalsIgnoreCase("123")) {
            req.getRequestDispatcher("/ProfiloAdmin.jsp").forward(req, resp);
            } else {
              if(gestione.controlloUtente(utente) && gestione.attivazioneUtente(utente)) {
            	try {
					session.setAttribute("immagineString", gestione.getImageString(utente));
					req.getRequestDispatcher("/ProfiloUtente.jsp").forward(req, resp);
				} catch (IOException | SQLException e) {
					e.printStackTrace();
				}
                } else if(!gestione.attivazioneUtente(utente) && gestione.controlloUtente(utente)) {
                req.setAttribute("messaggio", "Per effettuare l'accesso attiva il tuo account cliccando sul link dell'email che ti abbiamo inviato.");
              req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
              } 
            }
        } else {
          req.getRequestDispatcher("/Registrazione.jsp").forward(req, resp);
        }
  }
  
  
}