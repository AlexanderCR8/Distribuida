package com.distribuida.proxys;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.entidades.Ordenes;

@ApplicationScoped
public class OrderProxyImpl {

	@Inject private OrderProxy proxy;
	
	public List<Ordenes> obtenerOrdenes(){
		return proxy.listarTodos();
	}
	
	public Ordenes buscarPorId(Integer id) {
		return proxy.ordenPorId(id);
	}
	
	public void eliminarOrden(Integer id) {
		proxy.eliminar(id);
	}
	
	public void crear(Ordenes p) {
		 proxy.crear(p);
	}
	
	public Ordenes editar(Ordenes p) {
		return proxy.actualizar(p);
	}
	
	public List<Ordenes> buscarOrdenporCustomerId(Integer id) {
		return proxy.listarOrdenesconCustomerbyId(id);
	}
	
}
