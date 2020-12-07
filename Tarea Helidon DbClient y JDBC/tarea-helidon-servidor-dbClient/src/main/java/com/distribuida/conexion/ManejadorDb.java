package com.distribuida.conexion;




import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;

@ApplicationScoped
public class ManejadorDb {
	
	@Produces @ApplicationScoped
	public DbClient db() {
		Config config = Config.create();
		Config dbConfig= config.get("db");
		DbClient dbClient = DbClient.builder(dbConfig)
                .build();
		 return  dbClient;
		
	}
	
	

}
