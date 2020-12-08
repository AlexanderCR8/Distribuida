package com.distribuida.gateway;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//declara que esta clase proprociona un metodo @Bean y puede ser porcesada por el contenedor  
@Configuration
@EnableDiscoveryClient  // sirve para descubrir múltiples implementaciones de Discovery como eureka, cónsul, y en nuestro caso descubrir zookeeper
public class GatewayDiscoveryConfiguration {

	@Bean
    public DiscoveryClientRouteDefinitionLocator 
      discoveryClientRouteLocator( ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties ) {
		return new DiscoveryClientRouteDefinitionLocator( discoveryClient, properties );
    }
}
