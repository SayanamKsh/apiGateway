package com.ey.apigateway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeProductMapping {

 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
 	
	Long empId;
	Long productId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public EmployeeProductMapping() {
		super();
	}
	public EmployeeProductMapping(Long id, Long empId, Long productId) {
		super();
		this.id = id;
		this.empId = empId;
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "EmployeeProductMapping [id=" + id + ", empId=" + empId + ", productId=" + productId + "]";
	}
	
	
}
