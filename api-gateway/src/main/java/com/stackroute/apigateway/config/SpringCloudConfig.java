package com.stackroute.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r->r.path("/api/v1/admin/**").uri("http://localhost:9090/"))
                .route(r->r.path("/api/v1/assessment/**").uri("http://localhost:8085/"))
                .route(r->r.path("/api/v1/auth/**").uri("http://localhost:8090/"))
                .route(r->r.path("/api/v1/instructor/**").uri("http://localhost:8081/"))
                .route(r->r.path("/api/v1/learner/**").uri("http://localhost:8900/"))
                //mention all the routes of all the services
                .build();
    }

}
