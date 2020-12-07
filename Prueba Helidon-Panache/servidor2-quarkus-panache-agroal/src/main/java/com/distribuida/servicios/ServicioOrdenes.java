package com.distribuida.servicios;


import java.util.List;

import com.distribuida.entidades.Customer;
import com.distribuida.entidades.Ordenes;

public interface ServicioOrdenes {
	
	 void insertarOrdenes( Ordenes P);
	 
	 public List<Ordenes> obtenerOrdenes();
	 
	 void eliminarOrdenes(Integer id) ;
	 
	 void actualizarOrdenes(Ordenes p );
	 
	 Ordenes obtenerOrdenesPorId(Integer id);
	 
	 public List<Ordenes> obtenerOrdenesporIdCustomer(Integer id);
	 
	 public List<Customer> obtenerClientes();
	 
	 public List<Ordenes> obtenerOrdenesCustomer();
	 
	 public List<Ordenes> obtenerOrdenesbyIdCustomer(Integer id);

	
}
