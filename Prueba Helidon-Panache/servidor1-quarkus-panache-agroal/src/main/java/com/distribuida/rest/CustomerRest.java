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
import com.distribuida.entidades.Customer;
import com.distribuida.servicios.ServicioCustomer;


@Path("/customers")
@ApplicationScoped
public class CustomerRest {
	
	@Inject
	ServicioCustomer serviCustomer ;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> listaCustomers() {	
		List<Customer> lista = serviCustomer.obtenerCustomer();	
		return lista;
	}
	
	@GET
	@Path("/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer customerPorId(@PathParam ("id") Integer id)  {
		Customer p = serviCustomer.obtenerCustomerPorId(id);
		if (p == null) {
            throw new WebApplicationException("Customer con id : " + id + " no existe.", 404);
        }
		return p;
	}
	
	@Transactional
	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearCustomer(Customer p) {
		//el id debe ser null ya que se autogenera automaticamente
		if (p.id != null) {
            throw new WebApplicationException("el id se establecio de forma no valida.", 422);
        }
		serviCustomer.insertarCustomer(p);
		return Response.ok(p).build(); 
	}
	
	@Transactional
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarPersona(Customer p){
		if (p.id == null) {
            throw new WebApplicationException("el id se establecio de forma no valida.", 422);
        }
		serviCustomer.actualizarCustomer(p);
		
		return Response.ok(p).build();
	}

	@Transactional
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	public Response elimarAlbum(@PathParam ("id") Integer id) {
		Long id2=Long.valueOf(id);
		Customer cust = Customer.findById(id2);
		
		if (cust == null) {
            throw new WebApplicationException("Customer con id : " + id + " no existe.", 404);
        }
		serviCustomer.eliminarCustomer(id);
		return Response.ok().build();
		
	}

	@GET
	@Path("/customersbySurname/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public List <Customer> customerPorSurname(@PathParam ("surname") String surname)  {
		List <Customer> p = serviCustomer.obtenerCustomerporApellido(surname);
		if (p == null) {
            throw new WebApplicationException("Customer con apellido : " + surname + " no existe.", 404);
        }
		return p;
	}
	
	

}