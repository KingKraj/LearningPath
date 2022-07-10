package com.dummycodings.api.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder routeBuilder) {
		return routeBuilder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.setRequestHeader("c_session_id", "some session is here")
								.addResponseHeader("param", "paramvalue"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-convertion/**").uri("lb://currency-convertion")).build();
	}
}
