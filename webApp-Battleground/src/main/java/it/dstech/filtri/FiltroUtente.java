package it.dstech.filtri;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.dstech.modelli.Utente;


public class FiltroUtente implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session =  req.getSession();
		Utente utente =(Utente)	session.getAttribute("utente");
		if (utente==null) {
			req.setAttribute("messaggio", "Utente non loggato");
			req.getRequestDispatcher("/welcomeLibreria.jsp").forward(req, resp);
		}else {
			System.out.println(utente);
			chain.doFilter(req, resp);	
			 
		}
	}

	@Override
	public void destroy() {
	}
}
