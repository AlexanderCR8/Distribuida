package com.distribuida.proxys;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.entidades.Persona;


@ApplicationScoped
public class PersonaProxyImpl {

	@Inject private PersonaProxy proxy;
	
	public List<Persona> obtenerPersonas(){
		return proxy.listarTodos();
	}
	
	public void eliminarPersonas(Integer id) {
		proxy.eliminar(id);
	}
	
	public void crearPersona(Persona c) {
	 proxy.crear(c);
	}
	
	public void editarPersona(Persona c) {
		 proxy.actualizar(c);
	}
	
}
