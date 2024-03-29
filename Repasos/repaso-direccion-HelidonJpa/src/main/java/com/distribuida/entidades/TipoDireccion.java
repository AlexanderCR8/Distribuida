package com.distribuida.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tipodireccion")
@NamedQueries({
    @NamedQuery(name = "TipoDireccion.findAll", query = "SELECT p FROM TipoDireccion p"),
    @NamedQuery(name = "TipoDireccion.findById", query = "SELECT p FROM TipoDireccion p WHERE p.id = :id")
})
public class TipoDireccion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private Integer id;
	@Column(name = "descripcion")
	private String descripcion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
}
