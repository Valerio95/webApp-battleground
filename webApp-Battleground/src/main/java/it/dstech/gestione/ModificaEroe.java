package it.dstech.gestione;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import it.dstech.modelli.Eroe;
import it.dstech.modelli.Utente;

@WebServlet(urlPatterns = "/GestioneEroe")
public class ModificaEroe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  HttpSession session = req.getSession();
		  GestioneBattleground  gestione = new GestioneBattleground();
		  Eroe vecchioEroe = (Eroe) session.getAttribute("eroe");
		  Eroe nuovoEroe = new Eroe(req.getParameter("nome"), req.getParameter("potere"));
		  nuovoEroe.setCosto(Integer.parseInt(req.getParameter("costo")));
		  nuovoEroe.setHP(Integer.parseInt(req.getParameter("HP")));
		  Part image = req.getPart("image");  
		  Blob imageBlob;
		  
		  try {
			imageBlob = gestione.conversionePartToBlob(image);
			nuovoEroe.setImage(imageBlob);
			session.setAttribute("nuovoEroe", nuovoEroe);
			
			gestione.modificaEroe(nuovoEroe, vecchioEroe);
			
			List<Eroe> lista = gestione.stampaEroi();
			req.setAttribute("lista", lista);
			req.getRequestDispatcher("/ModificaEroe.jsp").forward(req, resp);
		 
		  } catch (IOException | SQLException e) {
			  e.printStackTrace();
    	  }
	  }
}
