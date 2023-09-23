package com.ey.apigateway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.apigateway.dao.EmployeeProductDAO;
import com.ey.apigateway.entity.EmployeeProductMapping;
import com.ey.apigateway.model.Employee;
import com.ey.apigateway.model.Product;
import com.ey.apigateway.repo.EmpProductMappingRepo;

@Service
public class EmployeeProductService {

	@Autowired
	EmpProductMappingRepo empProductMappingRepo;
	
	@Autowired
	EmployeeProductDAO employeeProductDAO;
	
	public List<Employee> getAllProductsForAllEmployees() {
		 
		List<Employee>listOfEmployees=new ArrayList<Employee>();
		listOfEmployees=employeeProductDAO.getAllEmployee();
		listOfEmployees.forEach(emp->emp.setPassword(null));
		for (Employee employee : listOfEmployees) {
			List<EmployeeProductMapping> listOfEmployeeAndProductMapping = empProductMappingRepo.findByEmpId(employee.getId());
			if(null !=listOfEmployeeAndProductMapping) {
				List<Product>listOfProducts=employeeProductDAO
						.getAllProducts(listOfEmployeeAndProductMapping
								.stream()
								.map(EmployeeProductMapping::getProductId)
								.collect(Collectors.toSet()));
				if(null!=listOfProducts && !listOfProducts.isEmpty()) {
					employee.setListOfProduct(listOfProducts);
				}
			}
		}
		return listOfEmployees.stream().filter(emp-> null!=emp.getListOfProduct() && !emp.getListOfProduct().isEmpty()).collect(Collectors.toList());
	}
	
	public EmployeeProductMapping addToCart(EmployeeProductMapping employeeProductMapping) {
		return empProductMappingRepo.save(employeeProductMapping);
	}

}
