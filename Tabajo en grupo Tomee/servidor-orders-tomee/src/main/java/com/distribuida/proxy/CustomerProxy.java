package com.distribuida.proxy;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.distribuida.entidades.Customer;

@RegisterRestClient(baseUri ="http://localhost:9091/customer-server/customers")
public interface CustomerProxy {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> listarTodos();
	
}
