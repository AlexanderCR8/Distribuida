package com.distribuida.proxys;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import com.distribuida.entidades.Customer;


@ApplicationScoped
public class CustomerProxyImpl {

	@Inject private CustomerProxy proxy;
	
	public List<Customer> obtenerClientes(){
		return proxy.listarTodos();
	}
	
	public void eliminarClientes(Integer id) {
		proxy.eliminar(id);
	}
	
	public void crear(Customer c) {
	 proxy.crear(c);
	}
	
	public void editar(Customer c) {
		 proxy.actualizar(c);
	}
	
	public List<Customer> buscarClientespoSurname(String surname) {
		return proxy.listarClientesporSurname(surname);
	}
}
