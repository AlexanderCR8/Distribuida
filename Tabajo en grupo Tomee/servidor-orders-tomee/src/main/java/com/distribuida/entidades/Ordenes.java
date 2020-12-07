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
import javax.persistence.Transient;


@Entity
@Table(name="orders")
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT p FROM Ordenes p"),
    @NamedQuery(name = "Ordenes.findByIdCustomer", query = "SELECT p FROM Ordenes p WHERE p.customer_id = :customer_id")
})
public class Ordenes  implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	public Long id;
	@Column(name = "item")
	public String item ;
	@Column(name = "price")
	public Double price ;
	@Column(name = "customer_id")
	public Long customer_id;
	@Transient 
	public String datosCliente ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	
}
