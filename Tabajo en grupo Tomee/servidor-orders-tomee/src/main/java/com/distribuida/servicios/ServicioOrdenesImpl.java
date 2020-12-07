package com.distribuida.servicios;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.distribuida.entidades.Customer;
import com.distribuida.entidades.Ordenes;
import com.distribuida.proxy.CustomerProxyImpl;




@ApplicationScoped
public class ServicioOrdenesImpl implements ServicioOrdenes{
	@PersistenceContext(unitName = "myCustomer_PU")
    EntityManager em;
	
	@Inject private CustomerProxyImpl servicioCliente;

	// metodo para insertar Ordenes
	@Override
	public Ordenes insertarOrdenes(Ordenes P)  {
		Ordenes ord = null;
		em.persist(P);
		ord = em.find(Ordenes.class, P.getId());
		return ord;
	}

	//metodo para obtener todas las Ordenes
	
	@Override
	public List<Ordenes> obtenerOrdenes()  {
		//List<Ordenes> lista = new ArrayList<>();
		return em.createNamedQuery("Ordenes.findAll", Ordenes.class).getResultList();
		//return em.createQuery("FROM Ordenes ", Ordenes.class).getResultList();
		
		
	}
	//metodo para eliminar una orden por Id
	@Override
	public void eliminarOrdenes(Integer id) {
		Ordenes ordenes = em.find(Ordenes.class, id);
		if (!ordenes.equals(null)) {
			em.remove(ordenes);
		}else {
			System.out.println("No se pudo eliminar, orden no existe en BD");
		}
	}

	//metodo para actualizar una orden 
	@Override
	public void actualizarOrdenes(Ordenes p)  {
		
		Ordenes orden = null;
		orden = em.find(Ordenes.class, p.getId());
		orden.setItem(p.getItem());
		orden.setPrice(p.getPrice());
		orden.setCustomer_id(p.getCustomer_id());
		em.merge(orden);	
	}
	
	//metodo para Obtener Ordenes por id
	@Override
	public Ordenes obtenerOrdenesPorId(Integer id)  {
		Ordenes orden = null;
		orden = em.find(Ordenes.class, id);
		return orden;
	}

	//metodo para obtener una lista de Ordenes por el Id del Customer
	@Override
	public List<Ordenes> obtenerOrdenesporIdCustomer(Integer id) {
		return em.createNamedQuery("Ordenes.findByIdCustomer", Ordenes.class).setParameter("customer_id", id).getResultList();
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
	
	
