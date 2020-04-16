package it.dstech.gestione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestioneBattleground {
	private  final long serialVersionUID = 1L;
	private  EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
	private  EntityManager em = emf.createEntityManager();

}
