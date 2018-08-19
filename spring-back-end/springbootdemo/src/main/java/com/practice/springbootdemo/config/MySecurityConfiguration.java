package com.practice.springbootdemo.config;

import com.practice.springbootdemo.repositories.UserRepository;
import com.practice.springbootdemo.services.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.server.authentication.HttpBasicServerAuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.adapter.DefaultServerWebExchange;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(new MyUserDetailsServiceImpl(userRepository))  // build users from the service
                .passwordEncoder(passwordEncoder());  // use the password encoder from the above Bean.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .cors() // allow CORS.
                .and()
                    .authorizeRequests()
                    .antMatchers("/user/save")
                    .permitAll()  // allow everyone to sign-up.
                .and()
                    .authorizeRequests()
                    .antMatchers("/user/**")
                    .hasRole("USER")  // allow users to access /user/** endpoints.
                .and()
                    .authorizeRequests()
                    .antMatchers("/admin/**")
                    .hasRole("ADMIN")  // allow admins to access /admin/** endpoints.
                .and()
                    .httpBasic()  // HTTP basic security. By default stateless, made stateful on the front end.

                    .authenticationEntryPoint((request, response, authException) -> {  // this is to prevent the browser from
                                                                                        // popping HTTP basic prompt if the user
                                                                                        // tries to visit the restricted endpoints.
                                                                                        // just redirect to 404 instead. Authorization allowed on
                                                                                        // AJAX requests made by Angular ONLY.
                        if (request.getHeader("X-Requested-With") == null){
                            response.sendRedirect("/page-not-found"); // non-existent page to show 404.
                        }
                    })
                .and()
                    .logout()
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")  // important to destroy session
                    .deleteCookies("XSRF-TOKEN")  // important when CSRF is enabled.
                    .permitAll()
                .and()
                    .csrf().disable();
    }

}
