package com.practice.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.CookieGenerator;

/**
 * MVC Configuration
 * Created by debanikd on 7/31/2018.
 */

@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {


    /**
     * This method was required for CORS configuration when testing the application
     * with the front-end running on a separate port from the back-end.
     * The front-end needed to make requests to the back-end's RESTful service.
     * This is not required in production when both runs on the same port.
     * @param registry CorsRegistry for the server.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedMethods("POST", "GET", "DELETE", "PUT", "PATCH")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true); // to allow sending cookies and credentials with requests (needed for session-id)
    }
}
