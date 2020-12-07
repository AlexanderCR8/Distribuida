package com.distribuida.proxy;

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
	
}
