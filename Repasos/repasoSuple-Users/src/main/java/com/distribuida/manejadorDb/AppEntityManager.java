package com.distribuida.manejadorDb;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class AppEntityManager {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persona");
	
	@ApplicationScoped
	@Produces
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}