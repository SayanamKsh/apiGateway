package com.ey.apigateway.model;

import java.util.List;
import java.util.Objects;


public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    private List<Product> listOfProduct;

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Product> getListOfProduct() {
		return listOfProduct;
	}


	public void setListOfProduct(List<Product> listOfProduct) {
		this.listOfProduct = listOfProduct;
	}


	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String password, List<Product> listOfProduct) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.listOfProduct = listOfProduct;
	}

	public Employee(Long id, String firstName, String lastName, String email, String password,
			List<Product> listOfProduct) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.listOfProduct = listOfProduct;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", listOfProduct=" + listOfProduct + "]";
	}


	@Override
    public int hashCode() {
        return Objects.hash(id,email);
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
               Objects.equals(email, employee.email);
    }
}
