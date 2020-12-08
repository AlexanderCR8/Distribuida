package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.distribuida.entidades.Persona;
import com.distribuida.entidades.TipoDireccion;
import com.distribuida.proxy.TipoDireccionProxyImpl;

@ApplicationScoped
public class ServicioPersonaImpl implements ServicioPersona{

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TipoDireccionProxyImpl direccionProxy ;
	@Override
	public List<Persona> obtenerPersonas() {
		return em.createNamedQuery("Persona.findAll", Persona.class).getResultList();
	}

	@Override
	public Persona obtenerPersonaPorId(Integer id) {
		Persona p = null;
		p = em.find(Persona.class, id);
		return p;
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
				.filter(obj1 -> obj.getTipoDireccion()==obj1.getId())
				.forEach(obj1 -> obj.setDatoDireccion(obj1.getDescripcion())));
		
		return listaPersona;
	}

}
