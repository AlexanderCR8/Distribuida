package com.distribuida.rest;

import java.nio.charset.StandardCharsets;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;
import org.eclipse.microprofile.config.inject.ConfigProperty;

// Path es el mapeo de nuestros servicios
@ApplicationPath("/")
@ApplicationScoped
public class RestApplication extends Application{
	@Inject
    @ConfigProperty(name="http.port", defaultValue = "8082")
    private Integer port;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object event) throws Exception{
    	//conexion con zookeeper
        CuratorFramework client = CuratorFrameworkFactory
                .newClient("localhost:2181", new RetryForever(5));
        client.start();
        
        //registro  de la instancia en zookeeper
        ServiceInstance<Object> serviceInstance = ServiceInstance.builder()
                .id("customer-server: " + port)
                .name("customer-server")
                .port(port)
                .address("127.0.0.1")
                .uriSpec(new UriSpec("{scheme}://{address}:{port}"))
                .build();

        ServiceDiscoveryBuilder.builder(Object.class)
                .basePath("services")
                .client(client)
                .thisInstance(serviceInstance)
                .build()
                .start();
        
        //Prueba de la configuracion de Zookeeper
        byte[] bytesN = client.getData().forPath("/db-config/name");
        String nombre = new String(bytesN, StandardCharsets.UTF_8);

        byte[] bytesJ = client.getData().forPath("/db-config/jdbcurl");
        String jdbcUrl = new String(bytesJ, StandardCharsets.UTF_8);

        byte[] bytesU = client.getData().forPath("/db-config/username");
        String usuario = new String(bytesU, StandardCharsets.UTF_8);

        byte[] bytesP = client.getData().forPath("/db-config/password");
        String password = new String(bytesP, StandardCharsets.UTF_8);
        
        //System.setProperty("passw", password);

        System.out.println("*Probando la Configuración de zookeeper*");
        System.out.println("**");
        System.out.println("nombre BD: "+nombre);
        System.out.println("jdbcUrl: "+jdbcUrl);
        System.out.println("usuario: "+usuario);
        System.out.println("password: "+password);
        System.out.println("**");
        System.out.println("**");


    }

    public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object event) {
        System.out.println("destroy");
    }

}
