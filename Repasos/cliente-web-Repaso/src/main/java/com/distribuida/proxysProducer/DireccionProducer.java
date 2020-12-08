package com.distribuida.proxysProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxys.DireccionProxy;

@ApplicationScoped
public class DireccionProducer {

	private static final String URL_SERVIDOR2 = "http://localhost:80/tipodirecciones";
	@Produces
	@ApplicationScoped
	public DireccionProxy getProxy() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SERVIDOR2));
		DireccionProxy proxy = target.proxy(DireccionProxy.class);
		return proxy;
	}

}
