package com.distribuida.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;



import com.distribuida.entidades.TipoDireccion;
import com.distribuida.proxys.DireccionProxyImpl;



@Named(value = "controladorDireccion")
@SessionScoped
public class TipoDireccionController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private DireccionProxyImpl servicioDireccion;
	
	private TipoDireccion direccion;
	
	private List<TipoDireccion> listaDirecciones;
	private List<TipoDireccion> listaDirecciones3;
	
	
	@PostConstruct
	public void init() {
		direccion = new TipoDireccion();
	}

	public List<TipoDireccion> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<TipoDireccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}
	
	public TipoDireccion getDireccion() {
		return direccion;
	}

	public void setDireccion(TipoDireccion p) {
		this.direccion = p;
	}

	
//	public String getApellido() {
//		return apellido;
//	}
//
//	public void setApellido(String apellido) {
//		this.apellido = apellido;
//	}
	public List<TipoDireccion> getListaDirecciones3() {
		return listaDirecciones3;
	}

	public void setListaDirecciones3(List<TipoDireccion> listaClientes3) {
		this.listaDirecciones3 = listaClientes3;
	}

	public String redireccionCrear() {
		direccion.setDescripcion(null);

		return "crearDireccion?faces-redirect=true";
	}
	public String redireccionDireccion() {
		listaDirecciones = servicioDireccion.obtenerDirecciones();
		listaDirecciones3 = servicioDireccion.obtenerDirecciones();
		
		return "vistaDireccion?faces-redirect=true";
	}
	
	public String eliminarDireccion(Integer id) {
		
		if(id==null) {
			return "vistaCliente?faces-redirect=true";
		}else {
			servicioDireccion.eliminarDireccion(id);
			listaDirecciones = servicioDireccion.obtenerDirecciones();
			return "vistaCliente?faces-redirect=true";
		}		
	}
	
	public String crearDireccion() {
		direccion.setId(null);
		servicioDireccion.crearDireccion(direccion);
		listaDirecciones = servicioDireccion.obtenerDirecciones();
		return "vistaDireccion?faces-redirect=true";
	}
	
	public String redireccionEditar(TipoDireccion cliedit) {		
		direccion = cliedit;
		return "editarDireccion?faces-redirect=true";
	}
	
	public String editar() {
		servicioDireccion.editarDireccion(direccion);
		return "vistaDireccion?faces-redirect=true";
	}
	
//	public void buscarApellido() {
//		
//		if(apellido=="") {
//			System.out.println("apellido nulo");
//			listaClientes=servicioCliente.obtenerClientes();
//		}else {
//		
//		System.out.println("id No nulo");
//		System.out.println(apellido);
//		listaClientes=servicioCliente.buscarClientespoSurname(apellido);
//		//listaClientes=servicioCliente.obtenerClientes();
//		}
//	}

	
}
