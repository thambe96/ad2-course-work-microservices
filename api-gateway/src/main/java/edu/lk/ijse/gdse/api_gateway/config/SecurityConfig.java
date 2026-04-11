package edu.lk.ijse.gdse.api_gateway.config;

import edu.lk.ijse.gdse.api_gateway.security.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final JwtAuthFilter jwtAuthFilter;


}
