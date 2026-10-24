package com.dormsupport.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutes {
    @Bean
    RouteLocator routes(
            RouteLocatorBuilder builder,
            @Value("${services.auth-uri:http://auth-service:8080}") String authUri,
            @Value("${services.issues-uri:http://issues-service:8080}") String issuesUri,
            @Value("${services.notifications-uri:http://notifications-service:8080}") String notificationsUri,
            @Value("${services.frontend-uri:http://frontend:80}") String frontendUri) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/v1/auth/**")
                        .filters(f -> f.rewritePath("/api/v1/auth/(?<segment>.*)", "/${segment}"))
                        .uri(authUri))
                .route("admin-auth-service", r -> r.path("/api/v1/admin/**")
                        .filters(f -> f.rewritePath("/api/v1/admin/(?<segment>.*)", "/admin/${segment}"))
                        .uri(authUri))
                .route("issues-service", r -> r.path("/api/v1/issues/**").uri(issuesUri))
                .route("notifications-service", r -> r.path("/api/v1/notifications/**")
                        .filters(f -> f.rewritePath("/api/v1/notifications/(?<segment>.*)", "/${segment}"))
                        .uri(notificationsUri))
                .route("frontend", r -> r.path("/", "/index.html").uri(frontendUri))
                .build();
    }
}
