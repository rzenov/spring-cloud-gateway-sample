package zenov.example.gateway.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties
public class UriConfiguration {
    private String httpbin = "http://httpbin.org:80";
}
