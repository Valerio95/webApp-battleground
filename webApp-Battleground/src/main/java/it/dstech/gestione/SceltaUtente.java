package it.dstech.gestione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.modelli.Composizione;
import it.dstech.modelli.Eroe;
import it.dstech.modelli.Partita;


@WebServlet(urlPatterns = "/SceltaUtente")
public class SceltaUtente extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("messaggio", "Pagina non accessibile");
    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
  }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GestioneBattleground gestione = new GestioneBattleground();

        if(req.getParameter("scelta").equalsIgnoreCase("Aggiungi partita")) {
        List<Composizione> listaComposizioni =	gestione.stampaComposizioni();
        List<Eroe> listaEroi =	gestione.stampaEroi();
        List<Partita> listaPartite =	gestione.stampaPartite();
         req.setAttribute("listaComposizioni", listaComposizioni);
         req.setAttribute("listaEroi", listaEroi);
         req.setAttribute("listaPartite", listaPartite);

          req.getRequestDispatcher("/CreaPartita.jsp").forward(req, resp);
        } else if (req.getParameter("scelta").equalsIgnoreCase("Statistiche")){
          req.getRequestDispatcher("/Statistiche.jsp").forward(req, resp);
          
        }else if (req.getParameter("scelta").equalsIgnoreCase("RimuoviAccount")) {
        	
            req.getRequestDispatcher("/RimuoviUtente.jsp").forward(req, resp);
            
          }else if (req.getParameter("scelta").equalsIgnoreCase("torna indietro")) {
          	
              req.getRequestDispatcher("/ProfiloUtente.jsp").forward(req, resp);
              
            }
      }
  }
