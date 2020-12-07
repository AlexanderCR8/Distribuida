package com.distribuida.proxy;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import com.distribuida.entidad.Ordenes;

@ApplicationScoped
public class PersonaProxyImpl {

	@Inject private PersonaProxy proxy;
	
	public List<Ordenes> obtenerPersonas(){
		return proxy.listarTodos();
	}
	
	public Ordenes buscarPorId(Integer id) {
		return proxy.personaPorId(id);
	}
	
	public void eliminarPersona(Integer id) {
		proxy.eliminar(id);
	}
	
	public Ordenes crear(Ordenes p) {
		return proxy.crear(p);
	}
	
	public Ordenes editar(Ordenes p) {
		return proxy.actualizar(p);
	}
}
