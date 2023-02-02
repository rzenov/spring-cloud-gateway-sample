package zenov.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import zenov.example.gateway.configuration.UriConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
public class SpringCloudGatewaySampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewaySampleApplication.class, args);
    }
}
