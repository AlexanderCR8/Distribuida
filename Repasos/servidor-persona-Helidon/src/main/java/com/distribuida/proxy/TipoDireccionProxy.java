package com.distribuida.proxy;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.distribuida.entidades.TipoDireccion;



@RegisterRestClient(baseUri ="http://localhost:8081/tipodirecciones")
public interface TipoDireccionProxy {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDireccion> listarTodos();
}
