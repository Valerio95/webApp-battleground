package it.dstech.gestione;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import org.apache.commons.io.IOUtils;
import it.dstech.modelli.Utente;
import it.dstech.utility.EmailUtility;


@WebServlet(urlPatterns = "/Registrazione")
@MultipartConfig
public class Registrazione extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("messaggio", "Pagina non accessibile");
    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	GestioneBattleground  gestione = new GestioneBattleground();
	HttpSession session = req.getSession();
	String username = req.getParameter("username");
    String password = req.getParameter("password");
    Part image = req.getPart("image");
    
    Blob imageBlob;
    
	try {
		imageBlob = gestione.conversionePartToBlob(image);
		
		Utente u = new Utente();
		u.setPassword(password);
		u.setUsername(username);
		u.setImage(imageBlob);
		session.setAttribute("utente", u);
    
    if(gestione.controlloUsername(u.getUsername())) {
      req.setAttribute("messaggio", "Attenzione: come username deve essere inserita una email valida");
      req.getRequestDispatcher("/Registrazione.jsp").forward(req, resp);
    }
    try {
      
      if(!gestione.controlloUtente(u)) {
    	  gestione.creazioneUtente(u);
    	  EmailUtility.sendEmail(u.getUsername(), "Conferma Mail", generaLinkValidazioneUtente(u));
    	  req.setAttribute("messaggio", "Controlla la mail per attivare l'account");
    	  req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
       	} else {
       		req.setAttribute("messaggio", "Mail già presente nel DB");
       		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
       	}
     } catch ( MessagingException e) {
    		e.printStackTrace(); 
     }
	} catch (IOException | SQLException e1) {
		e1.printStackTrace();
	}
  }
  

  private String generaLinkValidazioneUtente(Utente utente) {
    String validationPath = "http://localhost:8080/webApp-Battleground/validazione?utente=";
    return "Per attivare la mail clicca su questo link: " + validationPath + utente.getUsername();
  }
}
