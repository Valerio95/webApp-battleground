
package it.dstech.gestione;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.dstech.modelli.Utente;


@WebServlet(urlPatterns = "/")
public class GestioneBattleground extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		List<Utente> lista = em.createQuery("SELECT u FROM Utente u", Utente.class).getResultList();
		
		req.setAttribute("lista", lista);
		req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Utente utente = new Utente();
		

		utente.setUsername(req.getParameter("username"));
		utente.setPassword(req.getParameter("password"));
		
		
		em.getTransaction().begin();
		em.persist(utente);
		em.getTransaction().commit();
		
		
        doGet(req, resp);

	}

}
