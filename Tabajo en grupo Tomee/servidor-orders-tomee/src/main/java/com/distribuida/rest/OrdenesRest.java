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

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.distribuida.entidades.Ordenes;
import com.distribuida.servicios.ServicioOrdenes;


@Path("/orders")
@ApplicationScoped
public class OrdenesRest {

	@Inject
	private ServicioOrdenes servicio;
	@Inject
    @ConfigProperty(name="http.port", defaultValue = "8083")
	private Integer port;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordenes> listaOrdenes() {
		System.out.println("puerto corriendo: "+port);
		List<Ordenes> lista = servicio.obtenerOrdenesCustomer();
		return lista;
	}
	
	@GET
	@Path("/order/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ordenes ordenPorId(@PathParam (value="id") Integer id) {
		Ordenes p = servicio.obtenerOrdenesPorId(id);
		return p;
	}
	
	@POST
	@Transactional
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ordenes crearOrden(Ordenes p)  {
		Ordenes orden=null;
		try {
			orden = servicio.insertarOrdenes(p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orden ;
		
	}
	

	@PUT
	@Transactional
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
	

	@DELETE
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	public Response elimarOrden(@PathParam ("id") Integer id) {

		try {
			servicio.eliminarOrdenes(id);
			return Response.noContent().build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
	
	@GET
	@Path("/orderwithCustomerbyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordenes> ordenconCustomerbyId(@PathParam (value="id") Integer id) {
		List<Ordenes> p = servicio.obtenerOrdenesbyIdCustomer(id);
		return p;
	}
	
//	@GET
//	@Path("/customers")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Customer> listaCustomers() throws Exception {
//		
//		List<Customer> lista = servicio.obtenerClientes();
//		
//		return lista;
//	}


}