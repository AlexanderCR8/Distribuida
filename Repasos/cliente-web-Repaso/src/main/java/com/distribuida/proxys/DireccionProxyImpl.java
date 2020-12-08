package com.distribuida.proxys;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.entidades.TipoDireccion;

@ApplicationScoped
public class DireccionProxyImpl {

	@Inject private DireccionProxy proxy;
	
	public List<TipoDireccion> obtenerDirecciones(){
		return proxy.listarTodos();
	}
	
	public TipoDireccion buscarPorId(Integer id) {
		return proxy.ordenPorId(id);
	}
	
	public void eliminarDireccion(Integer id) {
		proxy.eliminar(id);
	}
	
	public void crearDireccion(TipoDireccion p) {
		 proxy.crear(p);
	}
	
	public TipoDireccion editarDireccion(TipoDireccion p) {
		return proxy.actualizar(p);
	}
	
//	public List<TipoDireccion> buscarOrdenporCustomerId(Integer id) {
//		return proxy.listarOrdenesconCustomerbyId(id);
//	}
	
}
