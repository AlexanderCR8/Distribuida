package com.distribuida.proxy;

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


import com.distribuida.entidad.Ordenes;

public interface PersonaProxy {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ordenes> listarTodos();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/persona/{id}")
	public Ordenes personaPorId(@PathParam ("id") Integer id);
	
	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ordenes crear(Ordenes p);
	
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Ordenes actualizar(Ordenes p);
	
	@DELETE
	@Path("/eliminar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String eliminar(@PathParam ("id") Integer id);
	
}
