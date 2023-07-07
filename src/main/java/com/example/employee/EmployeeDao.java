package com.example.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;
	public String addEmployee(Employees e) {
		empRepo.save(e);
		return "success";
		
	}
	
	public String addEmployeeListing(List<Employees> e) { 
	empRepo.saveAll(e);
	return "success";
	}
	public Employees getEmpId(int id)
	{
		return empRepo.findById(id).get();
		
	}
	public List <Employees> getEmployee()
	{
		return empRepo.findAll();
	}
	public String getDetail(int id)
	{
		empRepo.deleteById(id);
		return "deleted";
} 
	public List<Employees> getAllEmployee() {
		return empRepo.findAll();
	}
	
	
		public List<Employees> getBySalary(int salary1,int salary2)
		{
			return empRepo.getEmpsalary(salary1,salary2);
			
		}
		public String addtoEmployee(Employees e) throws AgeException,Exception {
			 empRepo.save(e);
			 return "success";
		}
		public String  addEmployeeName(Employees e) throws NameException,Exception {
			return empRepo.getEmpname(e);
		}
		
		public String findbySalary(Employees e) throws SalaryException,Exception {
			empRepo.save(e);
			return "success";
		}
}
