package com.distribuida.service;

import java.util.List;

import com.distribuida.entidades.Adress;
import com.distribuida.entidades.Company;
import com.distribuida.entidades.Geo;
import com.distribuida.entidades.Users;

public interface ServicioUsuario {
	public List<Users> obtenerPersonas();
	//public List<Object[]> obtenerUsers();
	public List<Adress> obtenerAdress();
	public List<Company> obtenerCompanys();
	public List<Geo> obtenerGeo();
	public Users insertarUsuarios(Users persona);
	public Company insertarCompany(Company company);
}
