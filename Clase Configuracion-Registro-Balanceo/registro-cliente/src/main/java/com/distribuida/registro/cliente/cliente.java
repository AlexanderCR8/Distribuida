package com.distribuida.registro.cliente;


import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;

public class cliente {

	
	public static String testRest(String url) {
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(url).path("/hola");
		
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
		String txt = builder.get(String.class);
		return txt;
		
	}
	public static void main2(String[] args) {
		
		ConsulClient client = new ConsulClient("127.0.0.1");
		
		//consulta de todos los servicios 
//		Response<Map<String,Service>> ss=client.getAgentServices();
//		Map<String,Service> servicios =ss.getValue();
//		
//		servicios.values()
//		.stream()
//		.filter(ser-> ser.getService().equals("hola-mundo"))
//		.forEach(ser-> {
//			System.out.printf("[%s:%s] http://%s:%d/hola\n",ser.getService(),ser.getId(),ser.getAddress(), ser.getPort());
//		});
		
		//consulta de servicios que estan buenos
		HealthServicesRequest request = HealthServicesRequest.newBuilder()
				.setPassing(true)
				.setQueryParams(QueryParams.DEFAULT)
				.build();
		Response<List<HealthService>> datos = client.getHealthServices("hola-mundo", request);
		
		datos.getValue()
			.stream()
			.map(ser ->ser.getService())
			.forEach(ser->{
				System.out.printf("[%s:%s] http://%s:%d/hola\n",ser.getService(),
						ser.getId(),
						ser.getAddress(),
						ser.getPort());
			});
		//balanceo de servidores igual
		//obtenemos la lista de los servidores  solo con la ip y puerto
		List<String>urls = datos.getValue()
		.stream()
		.map(ser ->ser.getService())
		.map(s -> String.format("http://%s:%d", s.getAddress(),s.getPort()))
		.collect(Collectors.toList());
		
		int max= urls.size();
		Random rd = new Random();

		for (int i = 0; i < 100; i++) {
			//balanceo randomico
			//int index =rd.nextInt(max);
			//balanceo homogeneo a todos por igual
			int index= i%max;
			String url = urls.get(index);
			System.out.println("URL -->"+url);
			//invocar al servicio
			String txt = testRest(url);
			System.out.println(txt);	
		}
		
		
	
	}
	
	public static void main(String[] args) {
	    while(true)
	    {
	       String url = "http://127.0.0.1";
	          System.out.println("URL -->"+url);
	          String txt = testRest(url);
	          System.out.println(txt);  
	    }
	  }

}
