package com.distribuida.principal;

import java.util.List;

import com.distribuida.entidades.TipoDireccion;
import com.distribuida.proxy.TipoDireccionProxyImpl;

import io.helidon.webserver.Routing.Rules;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class PersonaResource implements Service {

	private TipoDireccionProxyImpl bookManager = new TipoDireccionProxyImpl();
	@Override
	public void update(Rules rules) {
		rules
        .get("/", this::books);
		
	}
	
	private void books(ServerRequest serverRequest, ServerResponse serverResponse) {
        //get all books
        List<TipoDireccion> books = bookManager.listarTodos();
        //JsonArray jsonArray = from(books);
        serverResponse.send(books);
    }

}
