package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.distribuida.entidades.Customer;

@ApplicationScoped
public class ServicioCustomerImpl implements ServicioCustomer {
	
	 @PersistenceContext(unitName = "myCustomer_PU")
	    EntityManager em;

	@Override
	public Customer insertarCustomer(Customer P) {
		Customer cust = null;
		em.persist(P);
		cust = em.find(Customer.class, P.getId());
		return cust;
	}

	@Override
	public List<Customer> obtenerCustomer() {
		return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
	}

	@Override
	public void eliminarCustomer(Integer id) {
		Customer usuario = em.find(Customer.class, id);
		if (!usuario.equals(null)) {
			em.remove(usuario);
		}else {
			System.out.println("No se pudo eliminar, customer no existe en BD");
		}	
	}

	@Override
	public void actualizarCustomer(Customer p) {
		Customer cust = null;
		cust = em.find(Customer.class, p.getId());
		cust.setName(p.getName());
		cust.setSurname(p.getSurname());
		em.merge(cust);	
	}

	@Override
	public Customer obtenerCustomerPorId(Integer id) {
		//System.out.println("segunda entrada");
		Customer cust = null;
		cust = em.find(Customer.class, id);
		return cust;
	}

	@Override
	public List<Customer> obtenerCustomerporApellido(String surname) {
		return em.createNamedQuery("Customer.findBySurname", Customer.class).setParameter("surname", surname).getResultList();
		
	}

}
