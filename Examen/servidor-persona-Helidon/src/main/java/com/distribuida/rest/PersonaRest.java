package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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


import com.distribuida.entidades.Persona;
import com.distribuida.entidades.TipoDireccion;
import com.distribuida.servicios.ServicioPersona;


@Path("/personas")
@ApplicationScoped
public class PersonaRest {
	@Inject
	ServicioPersona serviPersona ;
	
	@GET
	@Path("/ping")
	public String Ping() {
		System.out.println("ping");
		return "ok";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> listaPersonas() {	
		
		List<Persona> lista = serviPersona.obtenerPersonasConDirecciones();	
		return lista;
	}
	
	@GET
	@Path("/persona/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona PersonaPorId(@PathParam (value="id") Integer id)  {
		Persona per = serviPersona.obtenerPersonaPorId(id);
		return per;
	}
	

	
	
}
