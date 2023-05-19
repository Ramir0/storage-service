package dev.amir.storageservice.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@ConditionalOnProperty(name="local.configuration.cors", havingValue="true")
public class UserConfiguration {
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration cors = new CorsConfiguration();
        cors.addAllowedMethod("*");
        cors.addAllowedHeader("*");
        cors.addAllowedOrigin("*");
        cors.setAllowCredentials(false);
        source.registerCorsConfiguration("/**", cors);
        return source;
    }
}
