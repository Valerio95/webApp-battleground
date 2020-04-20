package it.dstech.gestione;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import it.dstech.modelli.Utente;
import it.dstech.utility.EmailUtility;


@WebServlet(urlPatterns = "/Registrati")
public class Registrazione extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("messaggio", "Pagina non accessibile");
    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    HttpSession session = req.getSession();
    
    Part image = req.getPart("image");
    InputStream f= image.getInputStream();
    byte[] imageBytes = new byte[ (int)image.getSize()];
    f.read(imageBytes,0,imageBytes.length);
    f.close();
    String imageStr = Base64.getEncoder().encodeToString(imageBytes);
    
    Utente u = new Utente();
    u.setPassword(password);
    u.setUsername(username);
    u.setImage(imageStr);
    session.setAttribute("utente", u);
    
    if(controlloUsername(u.getUsername())) {
      req.setAttribute("messaggio", "Attenzione: come username deve essere inserita una email valida");
      req.getRequestDispatcher("/Registrazione.jsp").forward(req, resp);
    }
    
    try {
      GestioneBattleground  gestione = new GestioneBattleground();
      
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
  }
    
  private boolean controlloUsername(String username) {
    String regex = "/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(username);
    if(matcher.matches()) {
      return true;
    }
    return false;
  }

  private String generaLinkValidazioneUtente(Utente utente) {
    String validationPath = "http://localhost:8080/webApp-Battleground/validazione?utente=";
    return "Per attivare la mail clicca su questo link: " + validationPath + utente.getUsername();
  }
}
