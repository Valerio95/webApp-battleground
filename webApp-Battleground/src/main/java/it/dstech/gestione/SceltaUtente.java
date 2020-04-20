package it.dstech.gestione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SceltaUtente extends HttpServlet {
  private static final long serialVersionUID = 1L;

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        if(req.getParameter("scelta").equalsIgnoreCase("Aggiungi partita")) {
          req.getRequestDispatcher("/CreaPartita.jsp").forward(req, resp);
        } else {
          req.getRequestDispatcher("/Statistiche.jsp").forward(req, resp);
          
        }
      }
  }
