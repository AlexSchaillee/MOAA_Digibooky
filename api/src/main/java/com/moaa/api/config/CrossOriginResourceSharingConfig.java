package com.moaa.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Enables Cross Origin Resource Sharing.
 * Meaning: an application that's running on a different domain (origin) will be now
 * able to access the resources (REST endpoints) exposed by this back-end application.
 * If we don't enable this, our GUI (running on a different port and thus origin) will not
 * be able to access the REST endpoint.
 * <p>
 * Will be component scanned!
 * Press F4 on this annotation. You'll see it's annotated as @Component (@Named)
 */
@Configuration
public class CrossOriginResourceSharingConfig {

    private static final String ALLOWED_ORIGINS = "*";
    private static final String ALLOWED_PATH_MAPPINGS = "/**";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(ALLOWED_PATH_MAPPINGS)
                        .allowedOrigins(ALLOWED_ORIGINS)
                        .allowedMethods("POST", "PUT", "GET", "DELETE");
            }
        };
    }

}
