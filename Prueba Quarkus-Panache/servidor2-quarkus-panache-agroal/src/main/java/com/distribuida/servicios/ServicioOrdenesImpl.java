package com.distribuida.servicios;




import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.entidades.Customer;
import com.distribuida.entidades.Ordenes;
import com.distribuida.proxy.CustomerProxyImpl;



@ApplicationScoped
public class ServicioOrdenesImpl implements ServicioOrdenes{
	
	@Inject private CustomerProxyImpl servicioCliente;

	// metodo para insertar Ordenes
	@Override
	public void insertarOrdenes(Ordenes P)  {
		Ordenes.persist(P);	
	}

	//metodo para obtener todas las Ordenes
	@Override
	public List<Ordenes> obtenerOrdenes()  {
		List<Ordenes> listaOrdenes =Ordenes.listAll();
		//List<Ordenes> listaOrdenes = list("select o.id, o.item, o.price, o.customer_id from Ordenes o");
		
		return listaOrdenes;
	}
	//metodo para eliminar una orden por Id
	@Override
	public void eliminarOrdenes(Integer id) {
		Long id2=Long.valueOf(id);
		Ordenes.deleteById(id2);
	}

	//metodo para actualizar una orden 
	@Override
	public void actualizarOrdenes(Ordenes p)  {
		Ordenes.update("item = ?1, price=?2, customer_id=?3 where id = ?4",p.item,p.price,p.customer_id, p.id);
		
	}
	
	//metodo para Obtener Ordenes por id
	@Override
	public Ordenes obtenerOrdenesPorId(Integer id)  {
		Long id2=Long.valueOf(id);
		return Ordenes.find("id", id2).firstResult();
		
	}

	//metodo para obtener una lista de Ordenes por el Id del Customer
	@Override
	public List<Ordenes> obtenerOrdenesporIdCustomer(Integer id) {
		Long id2=Long.valueOf(id);
		return Ordenes.find("customer_id", id2).list();
	}

	//metodo para obtener una lista de todos los Customers
	@Override
	public List<Customer> obtenerClientes() {
		
		return servicioCliente.obtenerClientes();
	}

	//metodo para Obtener una lista de todas las Ordenes con datos del Customer
	@Override
	public List<Ordenes> obtenerOrdenesCustomer() {
		List<Ordenes> listaOrdenes = obtenerOrdenes();
		List<Customer> listaCustomer=obtenerClientes();
		
		listaOrdenes.forEach(obj2 -> listaCustomer.stream()
				.filter(obj1 -> obj2.customer_id==obj1.getId())
				.forEach(obj1 -> obj2.datosCliente=obj1.getName()+" "+obj1.getSurname()));
		   
        return listaOrdenes;
       }
		
	//metodo para Obtener una lista de todas las Ordenes con datos del Customer filtrado pór ID del Customer
	@Override
	public List<Ordenes> obtenerOrdenesbyIdCustomer(Integer id) {
		List<Ordenes> listaOrdenes = obtenerOrdenesporIdCustomer(id);
		List<Customer> listaCustomer=obtenerClientes();
		
		listaOrdenes.forEach(obj2 -> listaCustomer.stream()
				.filter(obj1 -> obj2.customer_id==obj1.getId())
				.forEach(obj1 -> obj2.datosCliente=obj1.getName()+" "+obj1.getSurname()));
		
		return listaOrdenes;
		
	}



	}
	
	
