package com.mehmetcobanoglu.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mehmetcobanoglu.dto.DtoEmployee;
import com.mehmetcobanoglu.service.IEmployeeService;

@SpringBootTest(classes = { ExceptionApplication.class })
class ExceptionApplicationTests {

	private IEmployeeService employeeService;

	@BeforeEach
	public void beforeEach() {
		System.out.println("before each çalişti...");
	}

	@Test
	public void testFindEmployeeById() {

		DtoEmployee employee = employeeService.findEmployeeById(4L);
		assertEquals(4, employee.getId());
	}

	@AfterEach
	public void AfterEach() {
		System.out.println("after each çalişti");
	}
}
