package com.uiuc.fp.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class SpringDataRestConfig
        implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {

        cors.addMapping("/*")
                .allowedOrigins("*")
                .allowedMethods("GET", "PUT", "DELETE", "PATCH", "POST")
                .allowCredentials(false).maxAge(3600);
    }
}
