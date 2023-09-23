package com.ey.apigateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import com.ey.apigateway.model.Employee;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig implements WebFluxConfigurer{
	
    private final RestTemplate restTemplate;
    @Autowired
    public SecurityConfig(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    
    @Bean
    public SecurityWebFilterChain springsecurityFilterChain(ServerHttpSecurity http) {
        http
        .csrf()
    		.disable()
        		.authorizeExchange()
        			.pathMatchers("/user/signUp", "/user/logIn","employee-management-service/v3/api-docs/swagger-config","attendance-service/v3/api-docs/swagger-config")
        			//.pathMatchers("/**")
        				.permitAll()
        					.anyExchange()
        						.authenticated()
        							.and()
        								.httpBasic();

        return http.build();
    }
    

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
    	List<UserDetails> users=new ArrayList<UserDetails>();
    	users.add(User.withDefaultPasswordEncoder().username("ksh").password("pass").roles("ADMIN").build());
		//employee-management-service
		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
	            "http://localhost:8081/user/employee",
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Employee>>() {} 
	        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
        	List<Employee> employees = responseEntity.getBody();
        	for (Employee employee : employees) {
        		users.add(User.withDefaultPasswordEncoder()
                        .username(employee.getEmail())
                        .password(employee.getPassword())
                        .roles("USER")
                        .build());
        	}
            return new MapReactiveUserDetailsService(users);
        } else {
            return null;
        }
    }
}
