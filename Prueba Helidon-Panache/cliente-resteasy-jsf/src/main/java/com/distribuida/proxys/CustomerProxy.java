package com.distribuida.proxys;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.distribuida.entidades.Customer;


public interface CustomerProxy {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Customer> listarTodos();
	
	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void crear(Customer c);
	
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Customer c);
	
	@DELETE
	@Path("/eliminar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String eliminar(@PathParam ("id") Integer id);
	
	@GET
	@Path("/customersbySurname/{surname}")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Customer> listarClientesporSurname(@PathParam ("surname") String surname);
	
	
}
