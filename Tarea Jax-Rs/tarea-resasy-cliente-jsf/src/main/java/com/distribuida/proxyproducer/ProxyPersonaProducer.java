package com.distribuida.proxyproducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxy.PersonaProxy;

@ApplicationScoped
public class ProxyPersonaProducer {
	
	private static final String URL_SINGER = "http://127.0.0.1:7001/personas";
	
	@Produces
	@ApplicationScoped
	public PersonaProxy getProxy() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SINGER));
		PersonaProxy proxy = target.proxy(PersonaProxy.class);
		return proxy;
	}
	
}
