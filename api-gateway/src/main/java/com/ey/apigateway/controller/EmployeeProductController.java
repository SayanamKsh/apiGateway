package com.ey.apigateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.apigateway.entity.EmployeeProductMapping;
import com.ey.apigateway.model.Employee;
import com.ey.apigateway.service.EmployeeProductService;


@RestController
@RequestMapping("/product")
@CrossOrigin
public class EmployeeProductController {

	@Autowired
	EmployeeProductService employeeProductService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<EmployeeProductMapping> addToCart(@RequestBody EmployeeProductMapping employeeProductMapping) {
		return new ResponseEntity<EmployeeProductMapping>(employeeProductService.addToCart(employeeProductMapping), HttpStatus.CREATED);
	}
	
	@GetMapping("/showAllEmpProdDetails")
	public ResponseEntity<List<Employee>> getAllProductsForAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeProductService.getAllProductsForAllEmployees(), HttpStatus.OK);
	}
}
