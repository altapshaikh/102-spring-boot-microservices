package com.ait.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ait.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	Page<EmployeeEntity> findByDept(String dept,Pageable pageable);
	
	@Query(value = "SELECT * FROM EMPLOYEE WHERE ID=:id",nativeQuery = true)
	public EmployeeEntity getEmployeeById(int id);
	
	@Query(value = "SELECT * FROM EMPLOYEE WHERE DEPT= :dept AND SALARY= :salary",nativeQuery = true)
	public List<EmployeeEntity> getEmployeeByDeptAndSalary(String dept, int salary);
	
	
}
