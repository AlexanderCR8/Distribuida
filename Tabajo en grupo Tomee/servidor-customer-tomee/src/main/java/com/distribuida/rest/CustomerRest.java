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

import com.distribuida.entidades.Customer;
import com.distribuida.servicios.ServicioCustomer;


@Path("/customers")
@ApplicationScoped
public class CustomerRest {
	
	@Inject
	ServicioCustomer serviCustomer ;
	@Inject
	@ConfigProperty(name="http.port", defaultValue = "8080")
	    private Integer port;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> listaCustomers() {	
		System.out.println("puerto corriendo :"+port);
		List<Customer> lista = serviCustomer.obtenerCustomer();	
		return lista;
	}
	
	@GET
	@Path("/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer customerPorId(@PathParam (value="id") Integer id)  {
		Customer sing = serviCustomer.obtenerCustomerPorId(id);
		return sing;
	}
	
	
	@POST
	@Transactional
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer crearCustomer(Customer p) {
		Customer cust = null;
		try {
			cust = serviCustomer.insertarCustomer(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}
	

	@PUT
	@Transactional
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
//
	@Transactional
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	public Response elimarCustomer(@PathParam (value="id") Integer id) {
		
		try {
			serviCustomer.eliminarCustomer(id);
			return Response.noContent().build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}

	@GET
	@Path("/customersbySurname/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public List <Customer> customerPorSurname(@PathParam (value="surname") String surname)  {
		List<Customer> sing = serviCustomer.obtenerCustomerporApellido(surname);
		return sing;
	}
	
	

}