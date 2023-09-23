package com.ey.apigateway.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties.SwaggerUrl;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class SwaggerController {

	 private final DiscoveryClient discoveryClient;
	 public SwaggerController(final DiscoveryClient discoveryClient) {this.discoveryClient=discoveryClient;}
	 
	 private static final List<String> SERVICES= Arrays.asList("");
	
	 
	 @GetMapping("/v3/api-docs/swagger-config")
	 public Map<String,Object> swaggerConfig(ServerHttpRequest serverHttpRequest) throws URISyntaxException{
		 
		 URI uri = serverHttpRequest.getURI();
		 String url=new URI(uri.getScheme(),uri.getAuthority(),null,null,null).toString();
		 Map<String,Object> swaggerConfig= new HashMap<String, Object>();
		 List<AbstractSwaggerUiConfigProperties.SwaggerUrl> swaggerURLs=new ArrayList<>();
		 
		 discoveryClient
		 	.getServices()
		 		.forEach(obj->System.out.print(obj.toString()));
		 		
		 discoveryClient
		 	.getServices()
		 		.stream()
		 			.filter(s->!SERVICES.contains(s))
		 				.forEach(serviceName->swaggerURLs.add(new SwaggerUrl("",url+"/"+serviceName+"/v3/api-docs",serviceName)));
		 swaggerConfig.put("urls", swaggerURLs);
		 return swaggerConfig;
	 }
}
