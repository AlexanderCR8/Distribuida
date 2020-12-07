package com.distribuida.proxysProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxys.OrderProxy;

@ApplicationScoped
public class OrderProducer {

	private static final String URL_SERVIDOR2 = "https://columba-distribuida42.herokuapp.com/orders";
	@Produces
	@ApplicationScoped
	public OrderProxy getProxy() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SERVIDOR2));
		OrderProxy proxy = target.proxy(OrderProxy.class);
		return proxy;
	}

}
