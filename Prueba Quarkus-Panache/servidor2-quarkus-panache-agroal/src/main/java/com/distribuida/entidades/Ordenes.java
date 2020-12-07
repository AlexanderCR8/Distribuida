package com.distribuida.entidades;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name="orders")
public class Ordenes extends PanacheEntityBase implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Long id;
	public String item ; 
	public Double price ; 
	public Long customer_id;
	@Transient //indica que este atributo no es persistente no es tomado en cuenta a la hora de persistir el Objeto
	public String datosCliente ;
	

	
}
