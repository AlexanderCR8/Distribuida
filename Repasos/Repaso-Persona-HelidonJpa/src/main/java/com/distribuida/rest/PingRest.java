package com.distribuida.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value="/ping")
public class PingRest {

	@GET
	public String Ping() {
		System.out.println("ping");
		return "ok";
	}
}
