package org.fsk.apigatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("paymentId", r -> r
                        .path("/payment/**")
                        .filters(item -> item
                                .addRequestHeader("Hello Header", "Payment Service Header Value")
                                )
                        .uri("http://localhost:9090")) //static routing
                .route("orderId", r -> r.path("/order/**").uri("lb://ORDERSERVICE")) //dynamic routing
                .build();
    }
}
