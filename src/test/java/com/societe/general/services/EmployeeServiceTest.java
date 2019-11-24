package com.societe.general.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.societe.general.domain.Employee;
import com.societe.general.repositories.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Mock
	private EmployeeRepository repository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEmployeesTest() {
		
		 Mockito.when(repository.findAll()).thenReturn(Arrays
					.asList(new Employee(1, "Ravi Shankar", "Prajapati", "MALE", "2019-08-03T18:13:27.000+0000", "IT")));

	//	when(repository.findAll()).thenReturn(Arrays
	//			.asList(new Employee(1, "Ravi Shankar", "Prajapati", "MALE", "2019-08-03T18:13:27.000+0000", "IT")));
		List<Employee> empList = employeeService.getEmployees();

		// assertEquals(new Employee(1, "Ravi Shankar", "Prajapati", "MALE",
		// "2019-08-03T18:13:27.000+0000", "IT"), empList);

	}
}
