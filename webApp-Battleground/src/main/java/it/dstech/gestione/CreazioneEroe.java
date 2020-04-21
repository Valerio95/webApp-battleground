package it.dstech.gestione;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Eroe;
import it.dstech.modelli.Partita;
import it.dstech.modelli.Utente;
@WebServlet(urlPatterns = "/CreazioneEroe")
public class CreazioneEroe extends HttpServlet {
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Eroe eroe= new Eroe();
	    eroe.setNome(req.getParameter("Nome"));
      eroe.setPotere(req.getParameter("potere"));
      eroe.setCosto(Integer.parseInt(req.getParameter("costo")));
      eroe.setHP(Integer.parseInt(req.getParameter("HP")));
      System.out.println(eroe);
     
	    HttpSession session = req.getSession();
	    session.setAttribute("eroe", eroe);    
	    GestioneBattleground gestione = new GestioneBattleground();
	    gestione.creazioneEroe(eroe);
	    List<Eroe> listaEroi =gestione.stampaEroi();
	    session.setAttribute("lista", listaEroi);    
	    req.getRequestDispatcher("AggiungiEroe.jsp").forward(req, resp);
	  }
}
