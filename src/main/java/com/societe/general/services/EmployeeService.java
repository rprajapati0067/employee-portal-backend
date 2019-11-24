package com.societe.general.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.societe.general.domain.Employee;
@Service
public interface EmployeeService {
	Employee save(Employee employee);
	List<Employee> getEmployees();
}
