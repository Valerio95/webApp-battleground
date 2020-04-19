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



@WebServlet(urlPatterns = {"/validazione"})
public class ControlloValidazione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mailUtente = req.getParameter("utente");
		GestioneBattleground gestione;
		HttpSession session = req.getSession();
		Utente utente = (Utente) session.getAttribute("utente");
		gestione = new GestioneBattleground();
		gestione.validaUtente(utente);
		gestione.close();
		req.setAttribute("messaggio", "L'utente " + mailUtente + " è stato validato");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
		
	}
}
