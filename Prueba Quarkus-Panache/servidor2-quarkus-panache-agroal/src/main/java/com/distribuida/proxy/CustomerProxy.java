package com.distribuida.proxy;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.core.MediaType;

import com.distribuida.entidades.Customer;

public interface CustomerProxy {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Customer> listarTodos();
	
	
}
