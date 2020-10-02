package de.nspiess.distributedapidoc.gateway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(
        title = "Distributed Spring Cloud API",
        version = "1.0",
        description = "Distributed Spring Cloud API v1.0"))
public class OpenApiConfig {

    @RefreshScope
    @Bean
    public CommandLineRunner openApiGroups(
            RouteDefinitionLocator locator,
            SwaggerUiConfigParameters swaggerUiParameters) {
        return args -> {
            List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
            definitions.stream()
                    .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
                    .forEach(routeDefinition -> {
                        String name = routeDefinition.getId().replaceAll("-service", "");
                        swaggerUiParameters.addGroup(name);
                    });
        };
    }
}
