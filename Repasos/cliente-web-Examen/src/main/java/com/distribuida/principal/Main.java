package com.distribuida.principal;


import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.glassfish.jersey.server.ResourceConfig;

import io.helidon.config.Config;
import io.helidon.media.jackson.JacksonSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.StaticContentSupport;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.jersey.JerseySupport;


public class Main {
	static Routing createRouting() {
        return Routing.builder()
        		.register("/persona",new PersonaResource())
        		.get("/hello", (req, res) -> res.send("Hello World1!"))
        		.register("/jersey", 
                        JerseySupport.create(new ResourceConfig(HellowWord.class)))

                .register("/ui", StaticContentSupport.builder("WEB")
                        .welcomeFileName("index.xhtml")
                        .build())
                .build();
    }
	public static void main(String[] args)  {
		
		JacksonSupport jacksonSupport = JacksonSupport.create();
		WebServer server = WebServer.builder(createRouting())
				.addMediaSupport(jacksonSupport)
                .port(8080)
                .build();
				
		server.start().thenAccept(ws -> {
            System.out.println("WEB server is up! http://localhost:" + ws.port());
        });
		
		server.whenShutdown()
        .thenRun(() -> System.out.println("WEB server is DOWN. Good bye!"));


	

	}

}
