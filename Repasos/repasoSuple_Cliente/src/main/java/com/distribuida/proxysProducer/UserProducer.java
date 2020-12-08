package com.distribuida.proxysProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxys.UserProxy;

@ApplicationScoped
public class UserProducer {
	private static final String URL_SERVIDOR1 = "http://localhost:7002/personas";

	@Produces
	@ApplicationScoped
	public UserProxy getProxy() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SERVIDOR1));
		UserProxy proxy = target.proxy(UserProxy.class);
		return proxy;
	}

}
