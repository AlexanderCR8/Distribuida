package com.distribuida.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.entidad.Ordenes;
import com.distribuida.proxy.PersonaProxyImpl;


@Named(value = "controladorPersona")
@SessionScoped
public class PersonaController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private PersonaProxyImpl servicioPersona;
	
	private Ordenes persona;
	
	private List<Ordenes> listaPersonas;
	
	@PostConstruct
	public void init() {
		persona = new Ordenes();
	}

	public List<Ordenes> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Ordenes> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	public Ordenes getPersona() {
		return persona;
	}

	public void setPersona(Ordenes p) {
		this.persona = p;
	}

	public String redireccionPersona() {
		listaPersonas = servicioPersona.obtenerPersonas();
		return "persona?faces-redirect=true";
	}
	
	public String eliminarPersona(Integer id) {
		servicioPersona.eliminarPersona(id);
		listaPersonas = servicioPersona.obtenerPersonas();
		return "persona?faces-redirect=true";
	}
	
	public String crearPersona() {
		servicioPersona.crear(persona);
		listaPersonas = servicioPersona.obtenerPersonas();
		return "persona?faces-redirect=true";
	}
	
	public String redireccionEditar(Ordenes persEdit) {
		persona = persEdit;
		return "editarPersona?faces-redirect=true";
	}
	
	public String editar() {
		 
		servicioPersona.editar(persona);
		return "persona?faces-redirect=true";
	}
	
}
