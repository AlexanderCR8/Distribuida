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

import com.distribuida.entidades.TipoDireccion;
import com.distribuida.servicios.ServicioTipoDireccion;

@Path("/tipodirecciones")
@ApplicationScoped
public class TipoDireccionRest {
	
	@Inject
	ServicioTipoDireccion servicioDireccion ; 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDireccion> obtenerTipoDirecciones(){
		List<TipoDireccion> lista = servicioDireccion.obtenerDirecciones();
		return lista;
		
	}
	
	@GET
	@Path("/tipodireccion/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDireccion obtenerTipoDireccionPorId(@PathParam(value="id") Integer id) {
		TipoDireccion tp = servicioDireccion.obtenerTipoDioreccionPorId(id);
		return tp;
	}
	
	@POST
	@Transactional
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TipoDireccion insertarTipoDireccion(TipoDireccion td) {
		TipoDireccion tipod=null;
		try {
			tipod=servicioDireccion.insertarTipoDireccion(td);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return tipod;
	}
	
	@DELETE
	@Transactional
	@Path("/eliminar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminarTipoDireccion(@PathParam(value="id") Integer id) {
		try {
			servicioDireccion.eliminarTipoDireccion(id);
			return Response.noContent().build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
	@PUT
	@Transactional
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizartipoDireccion(TipoDireccion td) {
		if (td.getId() == null) {
            throw new WebApplicationException("el id se establecio de forma no valida.", 422);
        }
		servicioDireccion.actualizarTipoDireccion(td);
		
		return Response.ok(td).build();
	}
	

}
