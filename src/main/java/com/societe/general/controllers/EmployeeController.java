package com.societe.general.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societe.general.domain.Employee;
import com.societe.general.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/register")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody  Employee employee) {
		logger.info("Employee Data: "+employee);
		
		
		Employee savedEmp = employeeService.save(employee);
		logger.info("Saved Emp: "+savedEmp);
		
		return new ResponseEntity<Employee>(savedEmp,HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/fetchAll")
	
	public ResponseEntity<List<Employee>> fetchAll() {
		
		List<Employee> employeeList = employeeService.getEmployees();
		
		
		logger.info("Emp List: "+employeeList);
		
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}
}
