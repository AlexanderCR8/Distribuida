package com.distribuida.servicios;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutionException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import com.distribuida.entidades.Persona;

import io.helidon.common.reactive.Single;

import io.helidon.dbclient.DbClient;
import io.helidon.dbclient.DbRow;


@ApplicationScoped
public class ServicioPersonaImpl implements ServicioPersona{
    
	@Inject
	private DbClient dbClient;
	

// metodo para listar todas las personas
	@Override
	public List<Persona> getPersona() throws SQLException {
		List<Persona> listaPersona1 = new ArrayList<Persona>();
		
        Single<List<DbRow>> rows = dbClient.execute(exec -> exec
        		.createQuery("select * from persona;").execute()).collectList();
            
        try {
            List<DbRow> listasPersonas = rows.get();
              
            if(!listasPersonas.isEmpty()) {
            	
            	for(int i=0; i< listasPersonas.size(); i++) {
            		Persona p = new Persona();
            		p.setId((int)listasPersonas.get(i).column("id").value());
            		p.setNombre((String)listasPersonas.get(i).column("nombre").value());
            		p.setDireccion((String)listasPersonas.get(i).column("direccion").value());
            		p.setCorreo((String)listasPersonas.get(i).column("correo").value());            		
            		listaPersona1.add(p);
            	}
            	
            }
           // listasPersonas.forEach(System.out::println);
           
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
        return listaPersona1;
		
	}


 @Override
 public void agregarPersona(Persona per) {
     dbClient.execute(exec -> exec
    		 .createInsert("INSERT INTO persona (nombre, direccion, correo) VALUES(?, ?, ?);")
             .addParam(per.getNombre()).addParam(per.getDireccion()).addParam(per.getCorreo())
             .execute())
             .thenAccept(count -> System.out.printf("Datos insertados", count) );
 }


@Override
public void eliminarPersona(Integer id) throws SQLException {
	dbClient.execute(exec -> exec
   		 .createDelete("DELETE FROM persona where id = ?;")
            .addParam(id)
            .execute())
            .thenAccept(count -> System.out.printf("Datos eliminados", count) );
	
}


@Override
public Persona obtenerPersonaPorId(Integer id) throws SQLException {
	Persona p = new Persona();
    Single<List<DbRow>> rows = dbClient.execute(exec -> exec
    		.createQuery("SELECT * FROM persona WHERE id = ?;")
    		.addParam(id)
    		.execute()).collectList();
    
  //  Single<List<Persona>> list = rows.collectList();
    try {
        List<DbRow> listasPersonas = rows.get();
       // listasPersonas.forEach(System.out::println);
        if(!listasPersonas.isEmpty()) {
        	for(int i=0; i< listasPersonas.size(); i++) {
        		p.setId((int)listasPersonas.get(i).column("id").value());
        		p.setNombre((String)listasPersonas.get(i).column("nombre").value());
        		p.setDireccion((String)listasPersonas.get(i).column("direccion").value());
        		p.setCorreo((String)listasPersonas.get(i).column("correo").value());
        	}
        	
        }
        
    } catch (InterruptedException e) {
        e.printStackTrace();
        return null;
    } catch (ExecutionException e) {
        e.printStackTrace();
        return null;
    }
    
    return p;
}


@Override
public void actualizarPersona(Persona p) throws SQLException {
	dbClient.execute(exec -> exec
	   		 .createUpdate("UPDATE persona SET nombre = ?, direccion = ? , correo = ? WHERE id = ?")
	            .addParam(p.getNombre()).addParam(p.getDireccion()).addParam(p.getCorreo()).addParam(p.getId())
	            .execute())
	            .thenAccept(count -> System.out.printf("Datos actualizados", count) );
}


}
