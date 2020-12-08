package com.distribuida.proxys;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.entidades.Adress;
import com.distribuida.entidades.Company;
import com.distribuida.entidades.Users;


@ApplicationScoped
public class UserProxyImpl {

	@Inject private UserProxy proxy;
	
	public List<Users> obtenerPersonas(){
		return proxy.listarTodos();
	}
	
	public List<Company> obtenerCompays(){
		return proxy.listarCompay();
	}
	public List<Adress> obtenerAdress(){
		return proxy.listarAdress();
	}
	
//	public void eliminarPersonas(Integer id) {
//		proxy.eliminar(id);
//	}
	
	public void crearPersona(Users c) {
	 proxy.crear(c);
	}
	
//	public void editarPersona(Users c) {
//		 proxy.actualizar(c);
//	}
	
}
