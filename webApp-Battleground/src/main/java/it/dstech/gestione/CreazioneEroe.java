package it.dstech.gestione;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;

import it.dstech.modelli.Eroe;

@WebServlet(urlPatterns = "/CreazioneEroe")
@MultipartConfig
public class CreazioneEroe extends HttpServlet {
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("messaggio", "Pagina non accessibile");
	    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	  }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  GestioneBattleground gestione = new GestioneBattleground();
		  HttpSession session = req.getSession();
		  Eroe eroe= new Eroe();
	 	    eroe.setNome(req.getParameter("nome"));
	       eroe.setPotere(req.getParameter("potere"));
	       eroe.setCosto(Integer.parseInt(req.getParameter("costo")));
	       eroe.setHP(Integer.parseInt(req.getParameter("HP")));
	       Part image = req.getPart("image");
      
      Blob imageBlob;
      
  	try {
  		
  		
  		 
       imageBlob = conversionePartToBlob(image);
	    eroe.setImage(imageBlob);
	    session.setAttribute("eroe", eroe);    
	    
	    gestione.creazioneEroe(eroe);
	    List<Eroe> listaEroi =gestione.stampaEroi();
	    req.setAttribute("lista", listaEroi);    
	    req.getRequestDispatcher("AggiungiEroe.jsp").forward(req, resp);
  	 } catch (  SQLException e) {
 		e.printStackTrace(); 
  }
	  }
	  private Blob conversionePartToBlob(Part image) throws IOException, SerialException, SQLException {
	    	InputStream immagine =image.getInputStream();
	    	Blob blob = null;
	    	byte[] content = IOUtils.toByteArray(immagine);
	    	blob = new SerialBlob(content);
	    	return blob;
	    }
}
