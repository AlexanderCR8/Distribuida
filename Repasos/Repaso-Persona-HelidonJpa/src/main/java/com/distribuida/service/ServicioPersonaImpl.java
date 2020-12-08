package com.distribuida.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.entidades.Persona;
import com.distribuida.entidades.TipoDireccion;
import com.distribuida.proxy.TipoDireccionProxyImpl;

@ApplicationScoped
public class ServicioPersonaImpl implements ServicioPersona {
	
	@Inject
	EntityManager em;
	
	@Inject
	private TipoDireccionProxyImpl direccionProxy ;
	
	@Override
	public List<Persona> obtenerPersonas() {
		List<Persona> personas;
		personas = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
		return personas;
	}
	
	@Override
	public Persona obtenerPersonaById(Integer id) {
		Persona per=null;
		per=em.find(Persona.class, id);
		return per;	
	}
	
	@Override
	public Persona insertarPersona(Persona persona) {
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
	public void editarPersona(Persona persona) {
		em.getTransaction().begin();
		em.merge(persona);
		em.getTransaction().commit();
	}

	

	@Override
	public void eliminarPersona(Integer id) {
		em.getTransaction().begin();
		Persona persona = em.find(Persona.class, id);
		if (!persona.equals(null)) {
			em.remove(persona);
			em.getTransaction().commit();
		}else {
			System.out.println("No se pudo eliminar, direccion no existe en BD");
		}
		
	}

	@Override
	public List<TipoDireccion> obtenerTipoDirecciones() {
		return direccionProxy.listarTodos();
	}

	@Override
	public List<Persona> obtenerPersonasConDirecciones() {
		List<Persona> listaPersona = obtenerPersonas();
		List<TipoDireccion> listaDireccion= obtenerTipoDirecciones();
		
		listaPersona.forEach(obj -> listaDireccion.stream()
				.filter(obj1 -> obj.getTipodireccion()==obj1.getId())
				.forEach(obj1 -> obj.setDatoDireccion(obj1.getDescripcion())));
		
		return listaPersona;
	}
	

}