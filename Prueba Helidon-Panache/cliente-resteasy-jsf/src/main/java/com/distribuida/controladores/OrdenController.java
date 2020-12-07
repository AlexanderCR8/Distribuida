package com.distribuida.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.entidades.Customer;
import com.distribuida.entidades.Ordenes;
import com.distribuida.proxys.CustomerProxyImpl;
import com.distribuida.proxys.OrderProxyImpl;


@Named(value = "controladorOrdenes")
@SessionScoped
public class OrdenController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private OrderProxyImpl servicioOrden;
	@Inject private CustomerProxyImpl servicioCliente;
	
	private com.distribuida.entidades.Ordenes orden;
	
	private List<Ordenes> listaOrdenes;
	private List<Customer> listaClientes2;
	
	private Integer idOrden;
	@PostConstruct
	public void init() {
		orden = new Ordenes();
	}

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public List<Ordenes> getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(List<Ordenes> listaPersonas) {
		this.listaOrdenes = listaPersonas;
	}
	
	public Ordenes getOrden() {
		return orden;
	}

	public void setOrden(Ordenes p) {
		this.orden = p;
	}

	public List<Customer> getListaClientes2() {
		return listaClientes2;
	}

	public void setListaClientes2(List<Customer> listaClientes2) {
		this.listaClientes2 = listaClientes2;
	}

	public String redireccionOrden() {
		listaOrdenes = servicioOrden.obtenerOrdenes();
		listaClientes2 = servicioCliente.obtenerClientes();
		return "vistaOrden?faces-redirect=true";
	}
	
	public String eliminarOrden(Integer id) {
		if(id==null){
			return "vistaOrden?faces-redirect=true";
		}else {
		servicioOrden.eliminarOrden(id);
		listaOrdenes = servicioOrden.obtenerOrdenes();
		return "vistaOrden?faces-redirect=true";
		}

	}
	
	public String crearOrden() {
		servicioOrden.crear(orden);
		listaOrdenes = servicioOrden.obtenerOrdenes();
		return "vistaOrden?faces-redirect=true";
	}
	
	public String redireccionEditar(Ordenes persEdit) {
		orden = persEdit;
		return "editarOrden?faces-redirect=true";
	}
	
	public String editar() {
		 
		servicioOrden.editar(orden);
		return "vistaOrden?faces-redirect=true";
	}
	
	public void buscarId() {
		
		if(idOrden==null) {
			System.out.println("id nulo");
			listaOrdenes=servicioOrden.obtenerOrdenes();
		}else {
		
		System.out.println("id No nulo");
		listaOrdenes=servicioOrden.buscarOrdenporCustomerId(idOrden);
		}
	}
	
public String redireccionCrear() {	
		orden.setId(null);
		orden.setItem(null);
		orden.setPrice(null);
		return "crearOrden?faces-redirect=true";
	}
	
}
