package it.dstech.gestione;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.dstech.modelli.Composizione;
import it.dstech.modelli.Eroe;



public class SceltaAdmin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String azione = req.getParameter("azione");
		if ("Aggiungi/rimuoviEroe".equalsIgnoreCase(azione)) {
			
				GestioneBattleground db = new GestioneBattleground();
				List<Eroe> lista = db.stampaEroi();
				session.setAttribute("lista", lista);
			
			
			req.getRequestDispatcher("/AggiungiRimuoviEroe.jsp").forward(req, resp);
		} else if ("Aggiungi/RimuoviComposizione".equalsIgnoreCase(azione)) {
			
				GestioneBattleground db = new GestioneBattleground();
			List<Composizione> lista = db.stampaComposizioni();
			session.setAttribute("lista", lista);
		
			
			req.getRequestDispatcher("/AggiungiRimuoviComposizione.jsp").forward(req, resp);
		}

}
}
