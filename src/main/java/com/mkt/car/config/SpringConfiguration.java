package com.mkt.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mkt.car.security.CustomAuthenticationEntryPoint;
import com.mkt.car.security.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SpringConfiguration {
	
	private final SecurityFilter securityFilter ;
	
	private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    public SpringConfiguration(SecurityFilter securityFilter, CustomAuthenticationEntryPoint authenticationEntryPoint) {
        this.securityFilter = securityFilter; 	
        this.authenticationEntryPoint = authenticationEntryPoint; 	
    }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(autorize -> autorize
						.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
						.requestMatchers(HttpMethod.POST, "/v1/api/Users").permitAll()
						.requestMatchers(HttpMethod.GET, "/v1/api/Users").permitAll()
						.requestMatchers(HttpMethod.GET, "/v1/api/Users/{id}").permitAll()
						.requestMatchers(HttpMethod.DELETE, "/v1/api/Users/{id}").permitAll()
						.requestMatchers(HttpMethod.PUT, "/v1/api/Users/{id}").permitAll()
						//.requestMatchers(HttpMethod.POST, "/v1/api/Users").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/v1/api/cars").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/v1/api/cars").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/v1/api/cars/{id}").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/v1/api/cars/{id}").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/v1/api/cars/{id}").hasRole("ADMIN")
						.anyRequest().authenticated()
				)
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
				 .exceptionHandling(configurer -> configurer.authenticationEntryPoint(authenticationEntryPoint))
				.build();
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {	return new BCryptPasswordEncoder();}
}
