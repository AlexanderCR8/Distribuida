package com.distribuida.servicios;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import com.distribuida.entidades.Customer;



@ApplicationScoped
public class ServicioCustomerImpl implements ServicioCustomer{

	//metodo para insertar cunstomer
	@Override
	public void insertarCustomer(Customer P)  {
		Customer.persist(P);
	}

	//metodo para obtener todos los customers
	@Override
	public List<Customer> obtenerCustomer()  {
		// el metodo list() toma fragmentos de consultas HQL y adapta el resto, esto lo conciso y legible 
		List<Customer> listaCustomers = Customer.listAll();
		return listaCustomers;
	}

	//metodo para eliminar un customers po su id
	@Override
	public void eliminarCustomer(Integer id)  {
		Long id2=Long.valueOf(id);
		Customer.deleteById(id2);
	}

	//metodo para actualizar un customer
	@Override
	public void actualizarCustomer(Customer p)  {
		//update("name = "+p.getName()+",surname"+p.getSurname()+ "where id = ?1", p.getId());
		Customer.update("name = ?1,surname=?2 where id = ?3",p.name,p.surname, p.id);
		
	}

	//metodo para obtener un customer por su id
	@Override
	public Customer obtenerCustomerPorId(Integer id)  {
		Long id2=Long.valueOf(id);
		return Customer.find("id", id2).firstResult();
		
	}

	//metodo para obtener una lista de customers por su Apellido
	@Override
	public List<Customer> obtenerCustomerporApellido(String surname) {
			try (Stream<Customer> cust = Customer.streamAll()) {
			
		    List<Customer> listaApellidos = cust   
		        .filter( n ->  n.surname.equals(surname) )
		        .collect(Collectors.toList());
		    
		    return listaApellidos;
		}
	}

	

	}
	
	
