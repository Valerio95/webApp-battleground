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
	private static final long serialVersionUID = 1L;

	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String azione =(String) req.getParameter("azione");
		  String nomeEroe= (String) req.getParameter("eroeDaRimuovere");
		  GestioneBattleground gestione = new GestioneBattleground();
		  if (azione.equalsIgnoreCase("rimuovi")) {
			  gestione.rimuoviEroe(nomeEroe);
			  List<Eroe> listaEroi= gestione.stampaEroi();
			  req.setAttribute("lista", listaEroi);
			  req.getRequestDispatcher("/GestioneEroe.jsp").forward(req, resp);
		  } else if(azione.equalsIgnoreCase("modifica")) {
			 HttpSession session = req.getSession();
			 List<Eroe> lista = gestione.stampaEroi();
			 Eroe eroe= gestione.getEroe(nomeEroe);
			 session.setAttribute("eroe", eroe);
			 req.setAttribute("lista", lista);
			 req.getRequestDispatcher("/ModificaEroe.jsp").forward(req, resp);
		 } else if (azione.equalsIgnoreCase("torna indietro")) {
			 List<Eroe> listaEroi = gestione.stampaEroi();
			 req.setAttribute("lista", listaEroi);
			 req.getRequestDispatcher("/GestioneEroe.jsp").forward(req, resp);
		 }
	  }
}
