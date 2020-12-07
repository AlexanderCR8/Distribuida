package com.distribuida.Principal;


import io.helidon.microprofile.server.Server;

public class ServerMain {

	public static void main(String[] args) {
		Server server= Server.create()
				.start();
		
		System.out.printf("servidor disponible en http://127.0.0.1:%d", server.port());

	}

}
