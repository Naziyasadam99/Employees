package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
	@Query(value="select*from employee where salary>=? and salary<=?",nativeQuery = true)
	
	
public List<Employees>getEmpsalary(int salary1,int salary2);
	
	@Query(value="select * from employee where name like ?",nativeQuery = true)
	public String getEmpname(Employees e);
	

	
}
