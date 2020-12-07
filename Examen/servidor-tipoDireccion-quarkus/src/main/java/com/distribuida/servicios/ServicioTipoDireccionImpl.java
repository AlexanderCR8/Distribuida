package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.distribuida.entidades.TipoDireccion;


@ApplicationScoped
public class ServicioTipoDireccionImpl implements ServicioTipoDireccion {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<TipoDireccion> obtenerDirecciones() {
		List<TipoDireccion> listaDirecciones = TipoDireccion.listAll();
		return listaDirecciones;
	}

	@Override
	public TipoDireccion obtenerTipoDioreccionPorId(Integer id) {
		Long id2=Long.valueOf(id);
		return  TipoDireccion.find("id", id2).firstResult();
	}



}
