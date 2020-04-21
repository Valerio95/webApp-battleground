package it.dstech.gestione;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.dstech.modelli.Composizione;
import it.dstech.modelli.Eroe;
import it.dstech.modelli.Utente;

@WebServlet(urlPatterns = "/SceltaAdmin")
public class SceltaAdmin extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String azione = req.getParameter("azione");
    if ("aggiungi eroe".equalsIgnoreCase(azione)) {
      
        GestioneBattleground db = new GestioneBattleground();
        List<Eroe> lista = db.stampaEroi();
        req.setAttribute("lista", lista);
        req.getRequestDispatcher("/AggiungiEroe.jsp").forward(req, resp);
        
    } else if ("rimuovi eroe".equalsIgnoreCase(azione)) {
      
      GestioneBattleground db = new GestioneBattleground();
      List<Eroe> lista = db.stampaEroi();
      req.setAttribute("lista", lista);
      req.getRequestDispatcher("/RimuoviEroe.jsp").forward(req, resp);
      
    } else if ("aggiungi composizione".equalsIgnoreCase(azione)) {
      
      GestioneBattleground db = new GestioneBattleground();
      List<Composizione> lista = db.stampaComposizioni();
      session.setAttribute("lista", lista);
      req.getRequestDispatcher("/AggiungiComposizione.jsp").forward(req, resp);
      
    } else if ("rimuovi composizione".equalsIgnoreCase(azione)) {
      
      GestioneBattleground db = new GestioneBattleground();
      List<Composizione> lista = db.stampaComposizioni();
      session.setAttribute("lista", lista);
      req.getRequestDispatcher("/RimuoviComposizione.jsp").forward(req, resp);
    }
    else if ("torna indietro".equalsIgnoreCase(azione)) {
        
        
        req.getRequestDispatcher("/ProfiloAdmin.jsp").forward(req, resp);
      }
  }
}