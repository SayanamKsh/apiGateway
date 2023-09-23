package com.ey.apigateway.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.apigateway.entity.EmployeeProductMapping;

@Repository
public interface EmpProductMappingRepo extends JpaRepository<EmployeeProductMapping,Long>{

	List<EmployeeProductMapping> findByEmpId(Long id);

}
