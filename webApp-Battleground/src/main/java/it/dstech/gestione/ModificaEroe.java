package it.dstech.gestione;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import it.dstech.modelli.Eroe;

@WebServlet(urlPatterns = "/ModificaEroe")
@MultipartConfig
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
		  System.out.println("Qui c'è il valore della request: "+ req.getParameter("nome"));
		  Eroe vecchioEroe = (Eroe) session.getAttribute("eroe");
		  Eroe eroeModificato = new Eroe();
		  eroeModificato.setNome(req.getParameter("nome"));
		  eroeModificato.setPotere(req.getParameter("potere"));
		  eroeModificato.setCosto(-1);
		  if(req.getParameter("costo") != null && !req.getParameter("costo").equals("")) {
			  eroeModificato.setCosto(Integer.parseInt(req.getParameter("costo")));
		  }
		  eroeModificato.setHP(-1);
		  if(req.getParameter("HP") != null && !req.getParameter("HP").equals("")) {
			  eroeModificato.setHP(Integer.parseInt(req.getParameter("HP")));
		  }
		  
		  Eroe nuovoEroe;
		  try {
			 
			  
			  nuovoEroe = gestione.checkNull(eroeModificato, vecchioEroe);
			  
			  
			  session.setAttribute("nuovoEroe", nuovoEroe);
			 
			  gestione.modificaEroe(nuovoEroe, vecchioEroe);
	
			  List<Eroe> lista = gestione.stampaEroi();
			  req.setAttribute("lista", lista);
			  req.getRequestDispatcher("/GestioneEroe.jsp").forward(req, resp); 
			  
		} catch (IOException | ServletException | SQLException e1) {
			e1.printStackTrace();
		}
	  }

}
