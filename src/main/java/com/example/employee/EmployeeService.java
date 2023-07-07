package com.example.employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao  empDao;
	
	public String addEmployee(Employees e)
	{
		return empDao.addEmployee(e);
	}
	
	public String addEmployeeLists(List<Employees> e) 
	{
		return empDao.addEmployeeListing(e);
	}
	
	public Employees getEmpId(int id) {
		return empDao.getEmpId(id);
	}
	public List<Employees> getEmployee() {
		return empDao.getEmployee();
	}
	public String getDetail(int id) {
		return empDao.getDetail(id);
	}
	public List<Employees> getBysalary(int salary)//we are perform operation in service class 
	{
		List<Employees >allEmployee = empDao.getAllEmployee();
		 return allEmployee.stream().filter((x)->x.getSalary()<salary).collect(Collectors.toList());
		 
	}
	public List<Employees> getByname(String name){
   List<Employees> allname = empDao.getAllEmployee();
   return allname.stream().filter((x)->x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
}
	public List<String> getEmpname(String gender) {
		return empDao.getAllEmployee().stream().filter((x)->x.getGender().equals(gender)).map((y)->y.getName()).collect(Collectors.toList());
		
	}
	public List<Employees> getBySalary(int salary1,int salary2) {
	return empDao.getBySalary(salary1,salary2);
	
	}
	public String addtoEmployee(Employees e) throws AgeException,Exception {
		//try {
		if(e.getAge()<18) {
			 throw new AgeException("your age is uneligible");
		}
		else
		{
			return empDao.addtoEmployee(e);
			
		}
	}
	  public String addEmployeeNames(Employees e) throws NameException,Exception {
		  if(e.getName().equals("#$%%"))
		  {
			  throw new NameException("enter correct letters");
			  
		  }
		  else
		  {
			  return empDao.addEmployeeName(e);
		  }
	  
	
	}
	  static Logger log = Logger.getLogger(EmployeeService.class);
	  
	  public String findbySalary(Employees e) throws SalaryException,Exception {
		  PropertyConfigurator.configure("log4jfile.properties");
		 
//		  try 
//		  {
		  if(e.getSalary()>30000)
		  {
			  log.error(new SalaryException("enter within 30000"));
			  throw new SalaryException("enter within 30000");
			  
		  }
		  else
		  {
			  return empDao.findbySalary(e); // try-catch block and globalhandling also there means try - catch block only execute; 
			  
		  }
		  //}
		 // catch(SalaryException se) /
		  //{
			//return "please enter correct Salary";
		 // }
	  }
	
	}

