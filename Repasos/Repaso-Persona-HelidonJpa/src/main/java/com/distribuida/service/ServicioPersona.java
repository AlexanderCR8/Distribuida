package com.distribuida.service;

import java.util.List;

import com.distribuida.entidades.Persona;
import com.distribuida.entidades.TipoDireccion;


public interface ServicioPersona {
	
	public Persona insertarPersona(Persona persona);
	public void editarPersona(Persona persona);
	public Persona obtenerPersonaById(Integer id);
	public void eliminarPersona(Integer id);
	public List<Persona> obtenerPersonas();
	public List<TipoDireccion> obtenerTipoDirecciones();
	public List<Persona> obtenerPersonasConDirecciones();

}
