package com.societe.general.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.societe.general.domain.Employee;
import com.societe.general.services.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Test
	public void fetchAllTest() throws Exception {
		when(employeeService.getEmployees()).thenReturn(Arrays
				.asList(new Employee(1, "Ravi Shankar", "Prajapati", "MALE", "2019-08-03T18:13:27.000+0000", "IT")));

		RequestBuilder request = MockMvcRequestBuilders.get("/employee/fetchAll").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"[{\"id\":1,\"firstName\":\"Ravi Shankar\",\"lastName\":\"Prajapati\",\"gender\":\"MALE\",\"dateOfBirth\":\"2019-08-03T18:13:27.000+0000\",\"department\":\"IT\"}]"))
				.andReturn();

		assertEquals(200, result.getResponse().getStatus());

	}

	@Test
	public void saveEmployeeTest() throws Exception {
		Employee employee = new Employee(1, "Ravi Shankar", "Prajapati", "MALE", "2019-08-03T18:13:27.000+0000", "IT");
		when(employeeService.save(employee)).thenReturn(employee);

		RequestBuilder request = MockMvcRequestBuilders.post("/employee/register").accept(MediaType.APPLICATION_JSON)
				.content(
						"{\"id\": 1,\"firstName\": \"Ravi Shankar\",\"lastName\": \"Prajapati\",\"gender\": \"MALE\",\"dateOfBirth\": \"2019-08-03T18:13:27.000+0000\",\"department\": \"IT\"}")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isCreated()).andReturn();

		assertEquals(201, result.getResponse().getStatus());

	}

}
