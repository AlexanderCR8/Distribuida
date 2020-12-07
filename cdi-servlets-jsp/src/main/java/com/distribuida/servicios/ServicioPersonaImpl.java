package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.entidades.Persona;


@ApplicationScoped
public class ServicioPersonaImpl implements ServicioPersona{
    
	
	private PreparedStatement pst = null;
	private Connection con = null;
	
	@Inject
	private DataSource datasource;
		
	String mensaje="";

	
	@Override
	public void agregarPersona(Persona P) throws SQLException {
		// sentencia sql para insertar (el id es autoincremental por eso no se pone)
		String sql = "INSERT INTO Persona( nombre, direccion, correo) VALUES(?,?,?)"; 
			
			try {
				//getConnection devuelve una conexion con el origen de datos
				con = datasource.getConnection();
				
				//pst: Objeto que representa una instruccion precompilada
				//hace que sea mas eficiente guarda la instruccion para ser ejecutada inmediatamante 
	            pst = con.prepareStatement(sql);
	            
	          //el nombre del primer interrogante es un string (le pasamos el nombre al primer  interrogante de la consulta )
	            pst.setString(1, P.getNombre());
	          //la direccion del segundo interrogante es un string   
	            pst.setString(2, P.getDireccion());
	          //el correo del tercer interrogante es un string   
	            pst.setString(3, P.getCorreo());
	            
	           //Ejecuta la instrucción SQL en este objeto, o una instrucción SQL que no devuelve nada, como una instrucción DDL.
	           //PreparedStatement INSERT UPDATE DELETE
	            pst.executeUpdate();
	            System.out.println("Resultado insertado correctamente ");
	            
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pst.close();
	            con.close();	            
			}
					
	}

// metodo para listar todas las personas
	@Override
	public List<Persona> getPersona() throws SQLException {
		String sql = "Select * from persona;"; 
		ResultSet rs = null;
        List<Persona> listaPersona = new ArrayList<Persona>();

        try {
            con = datasource.getConnection();
            pst = con.prepareStatement(sql);
            
          //executeQuery Ejecuta la consulta SQL en este objeto y devuelve el objeto generado por la consulta.
          //El objeto ResultSet proporciona varios métodos para obtener los datos de columna correspondientes a un fila
          ////El objeto de ResultSet mantiene un cursor que apunta a una fila de una tabla. 
            rs = pst.executeQuery(); 
          

            //rs.next metodo booleano (Mueve el cursor hacia adelante una fila desde su posición actual.)
            
            //con este metodo iteramos todas las filas y las almacena en una lista 
            while (rs.next()) {
                Persona p = new Persona();
                
                //rs.get() Recupera el valor de la columna designada en la fila actual de este objeto  
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDireccion(rs.getString(3));
                p.setCorreo(rs.getString(4));
                listaPersona.add(p);
                
               // System.out.println(rs.getString(2));
            }
           
        }catch(SQLException e) {
            System.out.println("ERROR AL OBTENER CONSULTA");
            e.printStackTrace();
        }finally {
        	rs.close();
        	pst.close();
            con.close();          
        }
        return listaPersona;
	}




	@Override
	public void eliminarPersona(Integer id) throws SQLException {
		
		//sql para  eliminar persona por id 
		String sql =" DELETE FROM persona where id = ?;";
		try {
			con = datasource.getConnection();
			
			//pst: Objeto que representa una instruccion precompilada
			pst = con.prepareStatement(sql);
			
			//el id del primer interrogante es un string (le pasamos el id al primer interrogante)
			pst.setInt(1, id);
			pst.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {      	
        	pst.close();
            con.close();     
        }
				
		
	}


	@Override
	public void actualizarPersona(Persona p) throws SQLException {
		String sql = "UPDATE persona SET nombre = ?, direccion = ?, correo = ?"
				   + "WHERE id = ?";
		try {
			con = datasource.getConnection();
            pst = con.prepareStatement(sql);
            //(le pasamos el nombre de tipo String al primer interrogante)
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getDireccion());
            pst.setString(3, p.getCorreo());
            pst.setInt(4, p.getId());         
            pst.executeUpdate();
           
		} catch (Exception e) {
			e.printStackTrace();
		} finally {      	
        	pst.close();
            con.close();
        }
		
		
	}



	// este metodo se lo usa para mostar los datos de una persona al momento de Actualizar la persona 
	@Override
	public Persona obtenerPersonaPorId(Integer id) throws SQLException {
		String sql = "SELECT * FROM persona WHERE id = ?;";
		ResultSet rs = null;
       // List<Persona> listaPersona = new ArrayList<Persona>();
		Persona person= new Persona();
        try {
        	con = datasource.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            //se usa if si se tiene una sola fila 
            if (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDireccion(rs.getString(3));
                p.setCorreo(rs.getString(4));              
                person =p;
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}finally {      		
            rs.close();
            pst.close();
            con.close();           
        }
		return person;
	}

}
