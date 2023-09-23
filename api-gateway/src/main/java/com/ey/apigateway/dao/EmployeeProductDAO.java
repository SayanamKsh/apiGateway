package com.ey.apigateway.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ey.apigateway.model.Employee;
import com.ey.apigateway.model.Product;

@Component
public class EmployeeProductDAO {

	@Autowired
	RestTemplate restTemplate;
	public List<Employee> getAllEmployee() {

		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
	            "http://localhost:8081/user/employee",
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Employee>>() {} );

	        if (responseEntity.getStatusCode().is2xxSuccessful()) {
	        	return responseEntity.getBody();
	        }
			return new ArrayList<Employee>();
	}
	public List<Product> getAllProducts(Set<Long> listOfProductIds) {
		HttpEntity<?> requestEntity = new HttpEntity<>(listOfProductIds);
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
	            "http://localhost:8083/product/getAllProductsIn",
	            HttpMethod.POST,
	            requestEntity,
	            new ParameterizedTypeReference<List<Product>>() {} );

	        if (responseEntity.getStatusCode().is2xxSuccessful()) {
	        	return responseEntity.getBody();
	        }
			return new ArrayList<Product>();
	}
}

