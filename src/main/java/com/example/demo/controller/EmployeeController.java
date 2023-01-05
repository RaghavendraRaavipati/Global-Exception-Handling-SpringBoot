package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	EmployeeServiceInterface employeeServiceInterface;
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee>listemps = employeeServiceInterface.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listemps, HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeById/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") Long idL){
		
		Employee emp = employeeServiceInterface.getEmployeeById(idL);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
		
			Employee emp = employeeServiceInterface.addEmployee(employee);
			return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteEmployeeById/{empid}")
	public ResponseEntity<Void>deleteEmployeeById(@PathVariable("empid") Long idL){
		employeeServiceInterface.deleteEmployeeById(idL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
		Employee emp = employeeServiceInterface.updateEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

}
