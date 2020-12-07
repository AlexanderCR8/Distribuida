package com.distribuida;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.helidon.microprofile.server.Server;

@Path("/hola")
@ApplicationScoped
public class HolaMundoRest {
	@Inject
	@ConfigProperty(name="config01/texto", defaultValue = "hola")private String msg;
	
	@Inject
	@ConfigProperty(name="config01/server.port", defaultValue = "8082")private Integer port;
	

	 @GET
	 @Produces(value = MediaType.APPLICATION_JSON)
	 public String hola() {
		 
			  //listar fuentes de configuracion
			//  Config config =  ConfigProvider.getConfig();
//			  config.getConfigSources()
//			   .forEach(s->System.out.println(s.getName()));
//			  
//			  Integer puerto = config.getValue("config01/server.port", Integer.class);
//			  System.out.println(puerto);
			  
			
//			  
			  
			  //return config.getValue("texto", String.class);
		 System.out.println(port);
		 return msg;
	 }


}
