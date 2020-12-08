package com.distribuida.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.entidades.Persona;
import com.distribuida.entidades.TipoDireccion;
import com.distribuida.proxys.PersonaProxyImpl;
import com.distribuida.proxys.DireccionProxyImpl;


@Named(value = "controladorPersona")
@SessionScoped
public class PersonaController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private DireccionProxyImpl servicioDireccion;
	@Inject private PersonaProxyImpl servicioPersona;
	
	private Persona persona;
	
	private List<Persona> listaPersona;
	private List<TipoDireccion> listadireccion;
	
	private Integer idOrden;
	@PostConstruct
	public void init() {
		persona = new Persona();
	}

	public Integer getIdPersona() {
		return idOrden;
	}

	public void setIdPersona(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public List<Persona> getListaPersona() {
		return listaPersona;
	}

	public void setListaPersona(List<Persona> listaPersonas) {
		this.listaPersona = listaPersonas;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona p) {
		this.persona = p;
	}

	
	public List<TipoDireccion> getListadireccion() {
		return listadireccion;
	}

	public void setListadireccion(List<TipoDireccion> listadireccion) {
		this.listadireccion = listadireccion;
	}


	public String redireccionPersona() {
		listadireccion = servicioDireccion.obtenerDirecciones();
		 listaPersona= servicioPersona.obtenerPersonas();
		return "vistaPersona?faces-redirect=true";
	}
	
	public String eliminarPersona(Integer id) {
		if(id==null){
			return "vistaPersona?faces-redirect=true";
		}else {
		servicioPersona.eliminarPersonas(id);
		listaPersona = servicioPersona.obtenerPersonas();
		return "vistaOrden?faces-redirect=true";
		}

	}
	
	public String crearPersona() {
		servicioPersona.crearPersona(persona);
		listaPersona = servicioPersona.obtenerPersonas();
		return "vistaPersona?faces-redirect=true";
	}
	
	public String redireccionEditar(Persona persEdit) {
		persona = persEdit;
		return "editarPersona?faces-redirect=true";
	}
	
	public String editar() {
		 
		servicioPersona.editarPersona(persona);
		return "vistaPersona?faces-redirect=true";
	}
	
//	public void buscarId() {
//		
//		if(idOrden==null) {
//			System.out.println("id nulo");
//			listaPersona=servicioPersona.obtenerPersonas();
//		}else {
//		
//		System.out.println("id No nulo");
//		listaPersona=servicioPersona.
//		}
//	}
	
public String redireccionCrear() {	
		persona.setId(null);
		persona.setCedula(null);
		persona.setDireccion(null);
		persona.setNombre(null);
		return "crearPersona?faces-redirect=true";
	}
	
}
