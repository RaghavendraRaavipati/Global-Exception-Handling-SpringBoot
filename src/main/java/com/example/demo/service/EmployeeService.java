 package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.custom.exception.EmptyInputException;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee addEmployee(Employee employee) {
		try
		{
			if(employee.getName().isEmpty() || employee.getName().length() == 0) {
				throw new EmptyInputException("601","Please send proper name, It is blank");
			}
		Employee savedEmployee = employeeDao.save(employee);
		return savedEmployee;
		}
		catch(Exception e)
		{
			throw new EmptyInputException("603","Something went wrong in service layer, while saving a employee"+e.getMessage());
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		try
		{
			List<Employee>empList = employeeDao.findAll();
			
			if(empList.isEmpty())
				throw new EmptyInputException("604","List is Empty");
			
			return empList;
		}
		
		catch(Exception e)
		{
			throw new EmptyInputException("605","Something went wrong in service layer, while trying to fetch all employees"+e.getMessage());
		}
		
	}

	@Override
	public Employee getEmployeeById(Long idL) {
		
		try
		{
			return employeeDao.findById(idL).get();
		}
		catch(IllegalArgumentException e)
		{
			throw new EmptyInputException("606","Given employee id is null"+e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			throw new EmptyInputException("607","For given employee id, there is no record matching in databse"+e.getMessage());
		}
		
	}

	@Override
	public void deleteEmployeeById(Long idL) {
		
		try
		{
			employeeDao.deleteById(idL);
		}
		catch(Exception e)
		{
			throw new EmptyInputException("608","Send correct Id"+e.getMessage());
		}
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		try
		{
			return employeeDao.save(employee);
		}
		catch(Exception e)
		{
			throw new EmptyInputException("609","Send correct Id"+e.getMessage());
		}
		
	}

}
