package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeServiceInterface {
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long idL);
	
	public void deleteEmployeeById(Long idL);
	
	public Employee updateEmployee(Employee employee);

}
