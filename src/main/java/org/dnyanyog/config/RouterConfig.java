package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("directory_route", r -> r.path("/api/user/v1/create/**").uri("http://localhost:8081"))
				.route("directory_route", r -> r.path("/api/user/v1/user/{user_id}**").uri("http://localhost:8081"))
				.route("event_route", r -> r.path("/event/venue/**").uri("http://localhost:8083")).build();
	}
}