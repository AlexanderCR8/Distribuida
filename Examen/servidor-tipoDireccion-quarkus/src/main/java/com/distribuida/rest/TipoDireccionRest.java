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

import com.distribuida.entidades.TipoDireccion;
import com.distribuida.servicios.ServicioTipoDireccion;

@Path("/tipodirecciones")
@ApplicationScoped
public class TipoDireccionRest {
	
	@Inject
	ServicioTipoDireccion servicioDireccion ; 
	
	@Inject
	@ConfigProperty(name = "quarkus.http.port", defaultValue = "8001")
	private Integer port;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDireccion> obtenerTipoDirecciones(){
		System.out.println("esta corriendo servidor direcciones: "+port);
		List<TipoDireccion> lista = servicioDireccion.obtenerDirecciones();
		return lista;
		
	}
	
	@GET
	@Path("/tipodireccion/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDireccion obtenerTipoDireccionPorId(@PathParam(value="id") Integer id) { 
		TipoDireccion tp = servicioDireccion.obtenerTipoDioreccionPorId(id);
		if (tp == null) {
            throw new WebApplicationException("Customer con id : " + id + " no existe.", 404);
        }
		return tp;
	}
	


}
