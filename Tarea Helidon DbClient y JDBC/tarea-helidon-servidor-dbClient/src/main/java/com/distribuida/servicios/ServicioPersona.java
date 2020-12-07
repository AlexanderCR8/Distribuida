package com.distribuida.servicios;


import java.sql.SQLException;
import java.util.List;


import com.distribuida.entidades.Persona;

public interface ServicioPersona {
	void agregarPersona( Persona P)throws SQLException;
	 
	 public List<Persona> getPersona() throws SQLException;
	 
	 void eliminarPersona(Integer id) throws SQLException;
//	 
	 void actualizarPersona(Persona p )throws SQLException;
	 
	 Persona obtenerPersonaPorId(Integer id)throws SQLException;
	
}
