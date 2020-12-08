package com.distribuida.servicios;

import java.util.List;

import com.distribuida.entidad.TipoDireccion;

public interface ServicioTipoDireccion {

	public List<TipoDireccion> obtenerDirecciones();
	public TipoDireccion obtenerTipoDioreccionPorId(Integer id);
	public TipoDireccion insertarTipoDireccion(TipoDireccion td);
	public void eliminarTipoDireccion(Integer id);
	public void actualizarTipoDireccion(TipoDireccion td);
	
	
}
