package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.distribuida.entidades.Adress;
import com.distribuida.entidades.Company;
import com.distribuida.entidades.Geo;
import com.distribuida.entidades.Users;
import com.distribuida.service.ServicioUsuario;

@Path("/personas")
@ApplicationScoped
public class PersonaRest {
	
	@Inject
	private ServicioUsuario servicioPer;
	
//	@Inject
//	@ConfigProperty(name = "server.port", defaultValue = "7001")
//	 private Integer port;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Users> obtenerPersonas() {
		List<Users> per = servicioPer.obtenerPersonas();
		return per;
	}
	
	@GET
	@Path("/adress")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Adress> obtenerUsers() {
		List<Adress> per = servicioPer.obtenerAdress();
		return per;
	}
	@GET
	@Path("/companys")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Company> obtenerCompanys() {
		List<Company> per = servicioPer.obtenerCompanys();
		return per;
	}
	
	@GET
	@Path("/geos")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Geo> obtenerGeos() {
		List<Geo> per = servicioPer.obtenerGeo();
		return per;
	}
	
	@POST
	@Path("/crearpersona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuarios(Users u) {
		if(u.getAdress().getId()==null || u.getCompany().getId()==null) {		
			throw new WebApplicationException("el id se establecio de forma no valida.", 422);
		}else {
			servicioPer.insertarUsuarios(u);
			return Response.ok(u).build();
		}
	}
	@POST
	@Path("/crearcompany")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearCompany(Company u) {
		try {
			Company urs=servicioPer.insertarCompany(u);
			return Response.ok(urs).build();
		}
		catch(Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
//	@GET
//	@Path("persona/{id}")
//	@Produces(value = MediaType.APPLICATION_JSON)
//	public Persona getPersonaById(@PathParam(value = "id") Integer id) {
//		Persona per =servicioPer.obtenerPersonaById(id);
//		return per;
//	}
//	
//	@POST
//	@Path("crear")
//	@Produces(value = MediaType.APPLICATION_JSON)
//	@Consumes(value = MediaType.APPLICATION_JSON)
//	public Persona crearPersonas(Persona persona) {
//		Persona per =null; 
//		try {
//			per =servicioPer.insertarPersona(persona);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return per;
//	}
//	
//
//	@DELETE
//	@Path("eliminar/{id}")
//	public Response eliminar(@PathParam(value = "id") Integer id) {
//		try {
//			servicioPer.eliminarPersona(id);
//			return Response.noContent().build();
//		} catch (Exception e) {
//			return Response.status(Response.Status.NOT_FOUND).build();
//		}
//		
//	}
//	
//	@PUT
//	@Path("actualizar")
//	@Produces(value = MediaType.APPLICATION_JSON)
//	@Consumes(value = MediaType.APPLICATION_JSON)
//	public Response editar(Persona persona) {
//		if (persona.getId() == null) {
//            throw new WebApplicationException("el id se establecio de forma no valida.", 422);
//        }
//		servicioPer.editarPersona(persona);
//		return Response.ok(persona).build();
//	}
//	
//	@GET
//	@Path("/direcciones")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<TipoDireccion> listaDirecciones() {	
//		System.out.println("hola");
//		List<TipoDireccion> lista = servicioPer.obtenerTipoDirecciones();	
//		return lista;
//	}
//	
}