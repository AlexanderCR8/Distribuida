package com.distribuida.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cedula")
	private String cedula;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "tipo_direccion")
	private Integer tipodireccion;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Transient
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
