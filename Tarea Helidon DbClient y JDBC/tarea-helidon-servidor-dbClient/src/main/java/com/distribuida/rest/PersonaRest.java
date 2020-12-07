package com.distribuida.rest;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.distribuida.entidades.Persona;
import com.distribuida.servicios.ServicioPersona;


@Path("/personas")
@ApplicationScoped
public class PersonaRest {
	@Inject
	private ServicioPersona servicio;
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> listaPersonas() throws SQLException{
		
		List<Persona> lista = servicio.getPersona();
		
		return lista;
	}
	
	@GET
	@Path("/persona/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona personaPorId(@PathParam ("id") Integer id) throws SQLException {
		Persona p = servicio.obtenerPersonaPorId(id);
		return p;
	}
	
	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearPersona(Persona p) throws SQLException {
		servicio.agregarPersona(p);
		return Response.ok(p).build(); 
	}
	
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarPersona(Persona p) throws SQLException {
		servicio.actualizarPersona(p);
		
		return Response.ok(p).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	public Response elimarPersona(@PathParam ("id") Integer id) throws SQLException {
		servicio.eliminarPersona(id);
		return Response.ok().build();
		
	}


}
