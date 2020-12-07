package com.distribuida.conexion;



import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class ManejadorDb {
	
	@Produces @ApplicationScoped
	public DataSource db() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://ec2-52-202-66-191.compute-1.amazonaws.com:5432/deds7j8e4nudn");
		ds.setUsername("kmxujeavhswvvd");
		ds.setPassword("5002b60465261f2f656cf4bff0dbf2b238d1b171c1c254d301965e9fcf475d58");
		return ds;
	}
	
	
// para conectar con postgres de heroku
//@Produces @ApplicationScoped	
//public DataSource db( ) {
//        
//        BasicDataSource ds = new BasicDataSource();
//
//        URI dbUri;
//        
//        try {
//            dbUri = new URI(System.getenv("DATABASE_URL"));
//            String username = dbUri.getUserInfo().split(":")[0];
//            String password = dbUri.getUserInfo().split(":")[1];
//            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
//            
//            ds.setDriverClassName( "org.postgresql.Driver" );
//            ds.setUrl( dbUrl );
//            ds.setUsername( username );
//            ds.setPassword( password );
//        } 
//        catch (URISyntaxException e) {
//            e.printStackTrace();
//            
//            throw new RuntimeException( "no se epuede conectar a la base de datos" );
//        }
//
//        
//        return ds;
//    }

}
