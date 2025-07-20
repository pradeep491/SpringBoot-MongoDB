package com.test;

import com.test.entity.Employee;
import com.test.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class JpaMapMappingTestApplication {
	@Autowired
	private static EmpRepository repository;

	public JpaMapMappingTestApplication(EmpRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaMapMappingTestApplication.class, args);
		Employee employee = new Employee();
		employee.setId(3L);
		employee.setName("Pradeep");
		employee.setType("Test");

		Map<String, String> departments = new HashMap<>();
		departments.put("IT", "Information Technology");
		departments.put("HR", "Human Resources");

		employee.setCustomMessages(departments);

		repository.save(employee);
		System.out.println("saved successfully...!");
		//Optional<Employee> op = repository.findById(1);
		//System.out.println(op.get());
	}

}
