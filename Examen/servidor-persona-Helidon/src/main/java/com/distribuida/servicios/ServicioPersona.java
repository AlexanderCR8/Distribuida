package com.distribuida.servicios;

import java.util.List;


import com.distribuida.entidades.Persona;
import com.distribuida.entidades.TipoDireccion;


public interface ServicioPersona {

	public List<Persona> obtenerPersonas();
	public  Persona obtenerPersonaPorId(Integer id);
	public List<TipoDireccion> obtenerTipoDirecciones();
	public List<Persona> obtenerPersonasConDirecciones();
}
