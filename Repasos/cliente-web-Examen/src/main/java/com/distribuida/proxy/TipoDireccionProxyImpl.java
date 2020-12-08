package com.distribuida.proxy;

import java.util.List;


import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
//import org.glassfish.jersey.process.internal.RequestScoped;

import com.distribuida.entidades.TipoDireccion;

//@RequestScoped
public class TipoDireccionProxyImpl {
	@Inject 
	@RestClient
	private TipoDireccionProxy proxy;

	public List<TipoDireccion> listarTodos() {
			System.out.println("hola");
			for (TipoDireccion obj : proxy.listarTodos()) {
				  System.out.println(obj.getDescripcion());
				}
		return proxy.listarTodos();
	}

}
