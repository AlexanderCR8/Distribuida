package com.distribuida.principal;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;



import com.distribuida.proxy.TipoDireccionProxyImpl;

@Path("/")
public class HellowWord {
	
	
		@GET
	    @Path("hello")
	    public Response hello() {
	        return Response.ok("Hello World2!").build();
	    }
//		@GET
//	    @Path("personas")
//	    public Response persona() {
//			
//	        return Response.ok(service.listarTodos()).build();
//	    }
}
