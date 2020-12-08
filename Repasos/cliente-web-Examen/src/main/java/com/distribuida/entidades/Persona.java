package com.distribuida.entidades;

import java.io.Serializable;


public class Persona {

	public Integer id;

	public String cedula ;

	public String direccion ;

	public Integer tipoDireccion ;

	public String nombre ;
	

	private String datoDireccion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(Integer tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDatoDireccion() {
		return datoDireccion;
	}
	public void setDatoDireccion(String datoDireccion) {
		this.datoDireccion = datoDireccion;
	}
	
	
	
}
