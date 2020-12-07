package com.distribuida.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.distribuida.entidades.Customer;
import com.distribuida.proxys.CustomerProxyImpl;


@Named(value = "controladorCliente")
@SessionScoped
public class CustomerController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private CustomerProxyImpl servicioCliente;
	
	private Customer cliente;
	
	private List<Customer> listaClientes;
	private List<Customer> listaClientes3;
	
	private String apellido;
	
	@PostConstruct
	public void init() {
		cliente = new Customer();
	}

	public List<Customer> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Customer> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public Customer getCliente() {
		return cliente;
	}

	public void setCliente(Customer p) {
		this.cliente = p;
	}

	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	


	public List<Customer> getListaClientes3() {
		return listaClientes3;
	}

	public void setListaClientes3(List<Customer> listaClientes3) {
		this.listaClientes3 = listaClientes3;
	}

	public String redireccionCrear() {
		cliente.setName(null);
		cliente.setSurname(null);
		return "crearCliente?faces-redirect=true";
	}
	public String redireccionCliente() {
		listaClientes = servicioCliente.obtenerClientes();
		listaClientes3 = servicioCliente.obtenerClientes();
		
		return "vistaCliente?faces-redirect=true";
	}
	
	public String eliminarCliente(Integer id) {
		
		if(id==null) {
			return "vistaCliente?faces-redirect=true";
		}else {
			servicioCliente.eliminarClientes(id);
			listaClientes = servicioCliente.obtenerClientes();
			return "vistaCliente?faces-redirect=true";
		}		
	}
	
	public String crearCliente() {
		cliente.setId(null);
		servicioCliente.crear(cliente);
		listaClientes = servicioCliente.obtenerClientes();
		return "vistaCliente?faces-redirect=true";
	}
	
	public String redireccionEditar(Customer cliedit) {		
		cliente = cliedit;
		return "editarCliente?faces-redirect=true";
	}
	
	public String editar() {
		servicioCliente.editar(cliente);
		return "vistaCliente?faces-redirect=true";
	}
	
	public void buscarApellido() {
		
		if(apellido=="") {
			System.out.println("apellido nulo");
			listaClientes=servicioCliente.obtenerClientes();
		}else {
		
		System.out.println("id No nulo");
		System.out.println(apellido);
		listaClientes=servicioCliente.buscarClientespoSurname(apellido);
		//listaClientes=servicioCliente.obtenerClientes();
		}
	}

	
}
