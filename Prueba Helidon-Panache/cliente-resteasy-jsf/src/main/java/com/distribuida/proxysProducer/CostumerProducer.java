package com.distribuida.proxysProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxys.CustomerProxy;

@ApplicationScoped
public class CostumerProducer {
	private static final String URL_SERVIDOR1 = "https://columba-distribuida41.herokuapp.com/customers";

	@Produces
	@ApplicationScoped
	public CustomerProxy getProxy() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SERVIDOR1));
		CustomerProxy proxy = target.proxy(CustomerProxy.class);
		return proxy;
	}

}
