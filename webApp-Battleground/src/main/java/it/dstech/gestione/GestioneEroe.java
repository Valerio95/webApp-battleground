package it.dstech.gestione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Eroe;

@WebServlet(urlPatterns = "/GestioneEroe")
public class GestioneEroe extends HttpServlet {
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String scelta =(String) req.getParameter("scelta");
		  String nomeEroe= (String) req.getParameter("eroeDaRimuovere");
		  
		  
		  System.out.println("Questo è il nome dell'eroe da eliminare "+nomeEroe);
		 GestioneBattleground gestione = new GestioneBattleground();
		 if (scelta.equalsIgnoreCase("rimuovi")) {
		 gestione.rimuoviEroe(nomeEroe);
		  List<Eroe> listaEroi= gestione.stampaEroi();
		  req.setAttribute("lista", listaEroi);
		  req.getRequestDispatcher("/RimuoviEroe.jsp").forward(req, resp);
		 }else if(scelta.equalsIgnoreCase("modifica")) {
			 List<Eroe> lista = gestione.stampaEroi();
			  req.setAttribute("lista", lista);
			  req.getRequestDispatcher("/ModificaEroe.jsp").forward(req, resp);
		 }
	  }
}
