package it.dstech.gestione;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Eroe;

public class CreazioneEroe extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Eroe eroe = new Eroe();
		
		eroe.setNome(req.getParameter("nome"));
		eroe.setCosto(Integer.parseInt(req.getParameter("costo")));
		eroe.setPotere(req.getParameter("potere"));
		eroe.setImage(Blob)session.getParameter("nome")));
		em.getTransaction().begin();
		em.persist(eroe);
		em.getTransaction().commit();
		
        doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		List<Utente> listaUtenti = em.createQuery("SELECT u FROM Utente u", Utente.class).getResultList();
		
		req.setAttribute("listaUtenti", listaUtenti);
		req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
	}
}
