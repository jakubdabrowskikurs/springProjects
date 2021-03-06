package com.springboot.h2;

import com.springboot.h2.controller.CarController;
import com.springboot.h2.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AppMainTest {

	@Autowired
	private CarController carController;

	@Autowired
	private EmployeeController employeeController;

	@Test
	public void contextLoads() {
		assertThat(carController).isNotNull();
		assertThat(employeeController).isNotNull();
	}
}
