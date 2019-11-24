package com.societe.general.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.general.domain.Employee;
import com.societe.general.repositories.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee save(Employee employee) {
		
		return repository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		
		return repository.findAll();
	}

}
