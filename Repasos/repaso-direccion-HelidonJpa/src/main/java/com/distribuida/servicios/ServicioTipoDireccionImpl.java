package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.distribuida.entidades.TipoDireccion;

@ApplicationScoped
public class ServicioTipoDireccionImpl implements ServicioTipoDireccion {

	@PersistenceContext(unitName = "direccion") 
	private EntityManager em;
	
	@Override
	public List<TipoDireccion> obtenerDirecciones() {
		return em.createQuery("SELECT p FROM TipoDireccion p", TipoDireccion.class).getResultList();
	}

	@Override
	public TipoDireccion obtenerTipoDioreccionPorId(Integer id) {
		TipoDireccion td = null;
		td=em.find(TipoDireccion.class, id);
		return td;
	}

	@Override
	public TipoDireccion insertarTipoDireccion(TipoDireccion td) {
		TipoDireccion tipod = null;
		em.persist(td);
		tipod=em.find(TipoDireccion.class, td.getId());
		
		return tipod;
	}

	@Override
	public void eliminarTipoDireccion(Integer id) {
		TipoDireccion tipod=em.find(TipoDireccion.class,id);
		if (!tipod.equals(null)) {
			em.remove(tipod);
		}else {
			System.out.println("No se pudo eliminar, direccion no existe en BD");
		}
		
	}

	@Override
	public void actualizarTipoDireccion(TipoDireccion td) {
		TipoDireccion tipod=null;
		tipod=em.find(TipoDireccion.class, td.getId());
		tipod.setDescripcion(td.getDescripcion());
		em.merge(tipod);
		
	}

}
