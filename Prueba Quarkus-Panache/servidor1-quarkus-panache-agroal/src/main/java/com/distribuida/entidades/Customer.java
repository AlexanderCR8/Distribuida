package com.distribuida.entidades;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


//Usando  patron de registro activo 

//para definir una entidad Panache se debe anotar con @Entity y extender de PanacheEntity o Panache EntityBase
@Entity
public class Customer extends PanacheEntityBase implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Long id;
	public String name ; 
	public String surname ; 
	

	
}
