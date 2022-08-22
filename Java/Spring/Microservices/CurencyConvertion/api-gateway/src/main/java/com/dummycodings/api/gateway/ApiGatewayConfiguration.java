package com.dummycodings.api.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouteLocator(RouteLocatorBuilder locator) {
		return locator.routes()
//				.route(p -> p.path("/currency-conversion/**")
//						.filters(f -> f.addRequestHeader("auth_token", "invalid token").addRequestParameter("accountid",
//								"superroot"))
//						.uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion/**")
						.filters(
								f -> f.rewritePath("/currency-tomoto/(?<segment>*)", "/currency-conversion/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
	}

}
