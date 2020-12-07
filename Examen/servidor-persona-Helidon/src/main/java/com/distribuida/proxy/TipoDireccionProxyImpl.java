package com.distribuida.proxy;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.distribuida.entidades.TipoDireccion;

@ApplicationScoped
public class TipoDireccionProxyImpl {
	@Inject 
	@RestClient
	private TipoDireccionProxy proxy;

	public List<TipoDireccion> listarTodos() {
			
		return proxy.listarTodos();
	}

}
