package a1.abhishek.databaseApp.service;

import java.util.List;

import a1.abhishek.databaseApp.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
