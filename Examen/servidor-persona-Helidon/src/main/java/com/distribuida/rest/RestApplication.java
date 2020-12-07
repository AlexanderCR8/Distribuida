package com.distribuida.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

//import com.ecwid.consul.v1.ConsulClient;
//import com.ecwid.consul.v1.agent.model.NewService;


@ApplicationPath("/")
@ApplicationScoped
public class RestApplication extends Application {
	
//	
//	@Inject
//	@ConfigProperty(name="server.port")private Integer port;
//	@Inject
//	@ConfigProperty(name="javax.sql.DataSource.personasDataSource.dataSource.password", defaultValue = "admin")private String password;
//	@Inject
//	@ConfigProperty(name="javax.sql.DataSource.personasDataSource.dataSource.url",defaultValue = "jdbc:postgresql://localhost/Examen")private String url;
//	@Inject
//	@ConfigProperty(name="javax.sql.DataSource.personasDataSource.dataSource.user",defaultValue = "postgres")private String usuario;
//	@Inject
//	@ConfigProperty(name="javax.sql.DataSource.personasDataSource.dataSourceClassName",defaultValue = "org.postgresql.ds.PGSimpleDataSource")private String className ;
//	
//	
//	private void init(@Observes @Initialized(ApplicationScoped.class) Object event) {
//		  System.out.println("init");
//		  System.out.println(port);
//		  //para el registro vamos a utilizar el consul api
//		  
//		  //consulCliente puede o no tener IP cuando es localhost
//		  ConsulClient client = new ConsulClient("localhost");
//		  NewService newService = new NewService();
//		  //con este ID se va a realizar el deregistro del servidor
//		  newService.setId("personas-" +port);//instancia
//		  newService.setName("personas");
//		  newService.setPort(port);
//		  newService.setAddress("127.0.0.1");
//		  
//		  //registar el URL para verificar si el servidor esa activo o no
//		  NewService.Check check = new NewService.Check();
//		  check.setMethod("GET");
//		  check.setHttp("http://127.0.0.1:" + port + "/personas/ping");
//		  check.setInterval("10s");
//		  check.setDeregisterCriticalServiceAfter("20s");
//		  newService.setCheck(check);
//		  
//		  client.agentServiceRegister(newService);
//		  
//		 }
//		 
//		 private void destroy(@Observes @Destroyed(ApplicationScoped.class) Object event) {
//		  System.out.println("destroy");
//		  ConsulClient client = new ConsulClient("localhost");
//		  client.agentServiceDeregister("personas-"+port);//instancia
//		 }
//		 

}
