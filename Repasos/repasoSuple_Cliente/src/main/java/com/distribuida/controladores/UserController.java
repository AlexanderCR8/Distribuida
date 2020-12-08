package com.distribuida.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.entidades.Adress;
import com.distribuida.entidades.Company;
import com.distribuida.entidades.Users;

import com.distribuida.proxys.UserProxyImpl;



@Named(value = "controladorPersona")
@SessionScoped
public class UserController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private UserProxyImpl servicioPersona;
	
	private Users persona;
//	private Integer idCompany;
//	private Integer idAdress;
	private Company company;
	private Adress adress;

	private List<Users> listaPersona;
	private List<Adress> listaAdress;
	private List<Company> listaCompany;
	

	@PostConstruct
	public void init() {
		persona = new Users();
		company = new Company();
		adress= new Adress();
	}


	public List<Users> getListaPersona() {
		return listaPersona;
	}

	public void setListaPersona(List<Users> listaPersonas) {
		this.listaPersona = listaPersonas;
	}
	
	public Users getPersona() {
		return persona;
	}

	public void setPersona(Users p) {
		this.persona = p;
	}

	

	public List<Adress> getListaAdress() {
		return listaAdress;
	}

	public void setListaAdress(List<Adress> listaAdress) {
		this.listaAdress = listaAdress;
	}

	public List<Company> getListaCompany() {
		return listaCompany;
	}

	public void setListaCompany(List<Company> listaCompany) {
		this.listaCompany = listaCompany;
	}
	
	
	

//	public Integer getIdCompany() {
//		return idCompany;
//	}
//
//
//	public void setIdCompany(Integer idCompany) {
//		this.idCompany = idCompany;
//	}
//
//
//	public Integer getIdAdress() {
//		return idAdress;
//	}
//
//
//	public void setIdAdress(Integer idAdress) {
//		this.idAdress = idAdress;
//	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Adress getAdress() {
		return adress;
	}


	public void setAdress(Adress adress) {
		this.adress = adress;
	}


	public String redireccionPersona() {
		listaAdress=servicioPersona.obtenerAdress();
		listaCompany=servicioPersona.obtenerCompays();
		
		 listaPersona= servicioPersona.obtenerPersonas();
		return "vistaPersona?faces-redirect=true";
	}
	
//	public String eliminarPersona(Integer id) {
//		if(id==null){
//			return "vistaPersona?faces-redirect=true";
//		}else {
//		servicioPersona.eliminarPersonas(id);
//		listaPersona = servicioPersona.obtenerPersonas();
//		return "vistaOrden?faces-redirect=true";
//		}
//
//	}
	
	public String crearPersona() {
		System.out.println("id Adress : "+adress.getId());
		System.out.println("id Company : "+company.getId());
		
		//persona.getAdress().setId(idAdress);
		persona.setAdress(adress);
		persona.setCompany(company);
		//persona.getCompany().setId(idCompany);
		servicioPersona.crearPersona(persona);
		listaPersona = servicioPersona.obtenerPersonas();
		return "vistaPersona?faces-redirect=true";
	}
	
	public String redireccionEditar(Users persEdit) {
		persona = persEdit;
		return "editarPersona?faces-redirect=true";
	}
	
//	public String editar() {
//		 
//		servicioPersona.editarPersona(persona);
//		return "vistaPersona?faces-redirect=true";
//	}
	
//	public void buscarId() {
//		
//		if(idOrden==null) {
//			System.out.println("id nulo");
//			listaPersona=servicioPersona.obtenerPersonas();
//		}else {
//		
//		System.out.println("id No nulo");
//		listaPersona=servicioPersona.
//		}
//	}
	
public String redireccionCrear() {	
		
		persona.setId(null);
		persona.setEmail(null);
		persona.setName(null);
		persona.setPhone(null);
		persona.setUsername(null);

		return "crearPersona?faces-redirect=true";
	}
	
}
