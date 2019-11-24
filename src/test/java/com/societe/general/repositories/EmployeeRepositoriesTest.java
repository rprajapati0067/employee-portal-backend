package com.societe.general.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.societe.general.domain.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoriesTest {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Test
	public void findAllTest() throws Exception {
		List<Employee> empList = repository.findAll();
		assertEquals(1, empList.size());

	}
	

}
