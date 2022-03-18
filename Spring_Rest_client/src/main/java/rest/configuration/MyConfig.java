package rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("rest")
public class MyConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
