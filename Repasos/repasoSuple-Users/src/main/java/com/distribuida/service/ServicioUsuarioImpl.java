package com.distribuida.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.entidades.Adress;
import com.distribuida.entidades.Company;
import com.distribuida.entidades.Geo;
import com.distribuida.entidades.Users;

@ApplicationScoped
public class ServicioUsuarioImpl implements ServicioUsuario {
	@Inject
	EntityManager em;
	
	@Override
	public List<Users> obtenerPersonas() {
		List<Users> personas;
		personas = em.createQuery("select u from Users u ", Users.class).getResultList();
		return personas;
	}

	@Override
	public List<Adress> obtenerAdress() {
		List<Adress> adress;
		adress = em.createQuery("select a from Adress a ", Adress.class).getResultList();
		return adress;
	}

	@Override
	public List<Company> obtenerCompanys() {
		List<Company> company;
		company = em.createQuery("select a from Company a ", Company.class).getResultList();
		return company;
	}

	@Override
	public List<Geo> obtenerGeo() {
		List<Geo> geo;
		geo = em.createQuery("select a from Geo a ", Geo.class).getResultList();
		return geo;
	}

	@Override
	public Users insertarUsuarios(Users persona) {
		try {
			em.getTransaction().begin();
			em.persist(persona);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return persona;
	}

	@Override
	public Company insertarCompany(Company company) {
		try {
			em.getTransaction().begin();
			em.persist(company);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return company;
	}
	
	
	
	
	
	

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Object[]> obtenerUsers() {
//		List<Object[]> personas;
//		personas = (List<Object[]>) em.createQuery("select u.name, u.username, u.email,d.street, d.suite, d.city, d.zipcode,e.lat, e.lng,u.phone,"
//				+ " u.website,o.name, o.catchphrase from Users u , Adress d, Geo e, Company o where u.adress.id = d.id and u.company.id=o.id "
//				+ "and d.geo.id=e.id").getResultList();
//		return personas;
//	}


}
