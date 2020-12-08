package com.distribuida.rest;

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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.distribuida.entidades.Persona;
import com.distribuida.entidades.TipoDireccion;
import com.distribuida.service.ServicioPersona;

@Path("/personas")
@ApplicationScoped
public class PersonaRest {
	
	@Inject
	private ServicioPersona servicioPer;
	
	@Inject
	@ConfigProperty(name = "server.port", defaultValue = "7001")
	 private Integer port;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Persona> obtenerPersonas() {
		System.out.println("esta corriendo servidor Persona: "+port);
		List<Persona> per = servicioPer.obtenerPersonasConDirecciones();
		return per;
	}
	
	@GET
	@Path("persona/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Persona getPersonaById(@PathParam(value = "id") Integer id) {
		Persona per =servicioPer.obtenerPersonaById(id);
		return per;
	}
	
	@POST
	@Path("crear")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Persona crearPersonas(Persona persona) {
		Persona per =null; 
		try {
			per =servicioPer.insertarPersona(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return per;
	}
	

	@DELETE
	@Path("eliminar/{id}")
	public Response eliminar(@PathParam(value = "id") Integer id) {
		try {
			servicioPer.eliminarPersona(id);
			return Response.noContent().build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
	@PUT
	@Path("actualizar")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response editar(Persona persona) {
		if (persona.getId() == null) {
            throw new WebApplicationException("el id se establecio de forma no valida.", 422);
        }
		servicioPer.editarPersona(persona);
		return Response.ok(persona).build();
	}
	
	@GET
	@Path("/direcciones")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDireccion> listaDirecciones() {	
		System.out.println("hola");
		List<TipoDireccion> lista = servicioPer.obtenerTipoDirecciones();	
		return lista;
	}
	
}