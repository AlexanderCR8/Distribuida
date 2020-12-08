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

import com.distribuida.entidades.Adress;
import com.distribuida.entidades.Company;
import com.distribuida.entidades.Users;


public interface UserProxy {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Users> listarTodos();
	
	@GET
	@Path("/companys")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Company> listarCompay();
	
	@GET
	@Path("/adress")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Adress> listarAdress();
	
	@POST
	@Path("/crearpersona")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void crear(Users c);
	
//	@PUT
//	@Path("/actualizar")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void actualizar(Users c);
//	
//	@DELETE
//	@Path("/eliminar/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public String eliminar(@PathParam ("id") Integer id);
	

	
	
}
