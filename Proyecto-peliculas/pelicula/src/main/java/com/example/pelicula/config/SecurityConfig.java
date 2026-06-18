package com.example.pelicula.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
    @Bean
    public UserDetailsService users(){

        UserDetails admin = User
        .withDefaultPasswordEncoder().username("admin").password("1234").roles("USER").build();

        UserDetails empleado = User
        .withDefaultPasswordEncoder().username("empleado").password("1234").roles("USER").build();

        return new InMemoryUserDetailsManager(admin, empleado);
    }
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        return http.build();
}
}
