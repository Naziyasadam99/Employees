package com.example.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/emp")
public class EmployeeControler {
	@Autowired
	EmployeeService empser;
	@PostMapping(value="/insert")
	public String addEmployee(@RequestBody Employees e) {
		return empser.addEmployee(e);
		
	}
	
	@PostMapping(value="insertall")
	public String addEmployeeList(@RequestBody List<Employees> e) {
		return empser.addEmployeeLists(e);
			
	}
	
	
   @GetMapping(value="findid/{id}")
	public Employees getEmpId(@PathVariable int id)
	{
		return empser.getEmpId(id);
		
	}
	@GetMapping(value="/employee") 
	public List<Employees> getEmployee()//--------------------// 
	{
		return empser.getEmployee();
	}
	@GetMapping(value="/deleteEmp/{id}")
public String  getDetail(@PathVariable int id)
{
		return empser.getDetail(id);
}
	@GetMapping(value="getbysalary/{salary}")
	public List<Employees> getBysalary(@PathVariable int salary)
	{
		return empser.getBysalary(salary);
	}
	@GetMapping(value="getbyname/{name}")
   public List<Employees> getByname(@PathVariable String name)
   {
		return empser.getByname(name);
   }
	@GetMapping(value="/getcount/{gender}")
	public List<String> getEmpname(@PathVariable String gender)
	{
		
		return empser.getEmpname(gender);
	}
	@GetMapping(value="/getSalary/{salary1}/{salary2}")
	public List<Employees> getBySalary(@PathVariable int salary1,@PathVariable int salary2)
	{
		return empser.getBySalary(salary1,salary2);
		
	}
	@PostMapping(value="/findByage")
	public String addtoEmployee(@RequestBody Employees e) throws AgeException,Exception//we use throws keyword beside any method//
	{
		return empser.addtoEmployee(e);
	}
	
	@PostMapping(value="insertName")
	public String addEmployeeNames(@RequestBody Employees e) throws NameException,Exception
	{
		return empser.addEmployeeNames(e);
		
	}
	@PostMapping(value="/findException")
	
	public String findbySalary (@RequestBody Employees e) throws SalaryException,Exception
		{
		return empser.findbySalary(e);	
		}
	
	
	
}
