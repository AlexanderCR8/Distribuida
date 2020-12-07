package com.distribuida.rest;

import java.sql.SQLException;
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
import com.distribuida.entidades.Ordenes;
import com.distribuida.servicios.ServicioOrdenes;


@Path("/orders")
@ApplicationScoped

public class OrdenesRest {

	@Inject
	private ServicioOrdenes servicio;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordenes> listaOrdenes() throws SQLException{
		
		List<Ordenes> lista = servicio.obtenerOrdenesCustomer();
		
		return lista;
	}
	
	@GET
	@Path("/order/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ordenes ordenPorId(@PathParam ("id") Integer id) {
		Ordenes p = servicio.obtenerOrdenesPorId(id);
		if (p == null) {
            throw new WebApplicationException("Orden con id : " + id + " no existe.", 404);
        }
		return p;
	}
	
	@Transactional
	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearOrden(Ordenes p)  {
		servicio.insertarOrdenes(p);
		//el id debe ser null ya que se autogenera automaticamente
		if (p.id != null) {
		    throw new WebApplicationException("el id se establecio de forma no valida.", 422);
		}
		return Response.ok(p).build(); 
	}
	
	@Transactional
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarOrden(Ordenes p) {
		if (p.id == null) {
            throw new WebApplicationException("el id se establecio de forma no valida.", 422);
        }
		servicio.actualizarOrdenes(p);
		
		return Response.ok(p).build();
	}
	
	@Transactional
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	public Response elimarOrden(@PathParam ("id") Integer id) {
		Long id2=Long.valueOf(id);
		Ordenes cust = Ordenes.findById(id2);
		if (cust == null) {
            throw new WebApplicationException("Customer con id : " + id + " no existe.", 404);
        }
		servicio.eliminarOrdenes(id);
		return Response.ok().build();
		
	}
	
	
	@GET
	@Path("/orderwithCustomerbyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordenes> ordenconCustomerbyId(@PathParam ("id") Integer id) {
		List<Ordenes> p = servicio.obtenerOrdenesbyIdCustomer(id);
		if (p == null) {
            throw new WebApplicationException("Customer con id : " + id + " no existe.", 404);
        }
		return p;
	}


}