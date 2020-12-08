package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.distribuida.entidad.TipoDireccion;

@ApplicationScoped
public class ServicioTipoDireccionImpl implements ServicioTipoDireccion {

	@PersistenceContext
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
		try {
			em.getTransaction().begin();
			em.persist(td);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
			return td;
	}

	@Override
	public void eliminarTipoDireccion(Integer id) {
		em.getTransaction().begin();
		TipoDireccion tipod=em.find(TipoDireccion.class,id);
		if (!tipod.equals(null)) {
			em.remove(tipod);
			em.getTransaction().commit();
		}else {
			System.out.println("No se pudo eliminar, direccion no existe en BD");
		}
		
	}

	@Override
	public void actualizarTipoDireccion(TipoDireccion td) {
		em.getTransaction().begin();
		em.merge(td);
		em.getTransaction().commit();
		
	}

}
