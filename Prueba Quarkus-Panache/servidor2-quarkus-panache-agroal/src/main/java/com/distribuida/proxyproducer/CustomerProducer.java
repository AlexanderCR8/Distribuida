package com.distribuida.proxyproducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxy.CustomerProxy;




@ApplicationScoped
public class CustomerProducer {
	
	private static final String URL_SERVIDOR1 = "https://columba-distribuida41.herokuapp.com/customers";
	
	@Produces
	public CustomerProxy getProxy() {
		ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SERVIDOR1));
		CustomerProxy proxy = target.proxy(CustomerProxy.class);
		return proxy;
	}
	
}
