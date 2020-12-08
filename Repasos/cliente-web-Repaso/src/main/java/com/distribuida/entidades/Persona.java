package com.distribuida.entidades;


public class Persona {

	private Integer id;
	private String cedula;
	private String direccion;
	private Integer tipodireccion;
	private String nombre;
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

	public Integer getTipodireccion() {
		return tipodireccion;
	}

	public void setTipodireccion(Integer tipodireccion) {
		this.tipodireccion = tipodireccion;
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
