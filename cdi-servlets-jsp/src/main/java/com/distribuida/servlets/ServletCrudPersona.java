package com.distribuida.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.entidades.Persona;
import com.distribuida.servicios.ServicioPersona;



//name: nombre del servlet ; urlPatterns 
@WebServlet(name = "crudPersona", urlPatterns = { "/crudPersona" })
public class ServletCrudPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private ServicioPersona servicio;
	
	
    
    public ServletCrudPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//El método getParameter recupera un parametro del request
		String action = request.getParameter("action");
		//System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "crear":
				crear(request, response);
				break;
			case "listar":
				listar(request, response);
				break;
			case "insertar":
				insertar(request, response);
			break;
			case "mostrarEditar":
				mostrarEditar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// Este método solo esta accesible desde los formularios.
	//Se envían los parámetros de forma implícita junto a la página,
	//es decir, al pasar los parámetros, nosotros no vemos reflejado en ningún sitio qué parámetros son y cual es su valor.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/crear.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		try {
			
			Persona persona = new Persona();
			
			persona.setId(0);
			persona.setNombre(request.getParameter("txtNombre"));
			persona.setDireccion(request.getParameter("txtDireccion"));
			persona.setCorreo(request.getParameter("txtCorreo"));
			
			
			servicio.agregarPersona(persona);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listar.jsp");
		List<Persona> listaPersona= servicio.getPersona();
		
//		Persona person ;
//		Iterator iter = listaPersona.iterator();
//		while(iter.hasNext()){
//		  person = (Persona)iter.next(); /* Cast del Objeto a la Clase Persona*/
//		  System.out.println(person.getNombre());/* Accedo a los atributos de la clase 
//		                                           por medio de sus Getters*/
//		}
			
		request.setAttribute("lista", listaPersona);
		dispatcher.forward(request, response);
	}
	
	private void mostrarEditar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, NumberFormatException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
		Persona persona = servicio.obtenerPersonaPorId(Integer.parseInt(request.getParameter("id")));
				
		request.setAttribute("persona", persona);
		dispatcher.forward(request, response);
		
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			
			Persona p = new Persona();
			p.setId(Integer.parseInt(request.getParameter("txtId")));
			p.setNombre(request.getParameter("txtNombre"));
			p.setDireccion(request.getParameter("txtDireccion"));
		    p.setCorreo(request.getParameter("txtCorreo"));
		
			servicio.actualizarPersona(p);
			//redirijo a la pantalla de listar
			listar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, NumberFormatException, SQLException {
		servicio.eliminarPersona(Integer.parseInt(request.getParameter("id")));
		//redirijo a la pantalla de listar
		listar(request, response);

	}

	
}
