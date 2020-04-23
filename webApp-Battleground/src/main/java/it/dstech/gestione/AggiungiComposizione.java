package it.dstech.gestione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.modelli.Composizione;
@WebServlet(urlPatterns = "/AggiungiComposizione")
public class AggiungiComposizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String nome=(String) req.getParameter("composizione");
		  Composizione composizione =new Composizione();
		  composizione.setNome(nome);
		  GestioneBattleground gestione = new GestioneBattleground();
		  gestione.aggiungiComposizione(composizione);
		 List<Composizione> listaComposizione= gestione.stampaComposizioni();
		  req.setAttribute("lista",listaComposizione );
		  req.getRequestDispatcher("/AggiungiComposizione.jsp").forward(req, resp);;
	  }

}
