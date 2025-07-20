package com.test;

import java.util.Arrays;
import java.util.List;

public class EmployeeDAO {

	public static List<Employee> getEmployees() {
		List<Employee> list = Arrays.asList(new Employee(491, "pradeep", "IT", 150000L),
				new Employee(492, "Punnu", "MEDICAL", 300000L), new Employee(493, "Jasvin", "Government", 200000L),
				new Employee(494, "Jyotshna", "HOUSE", 10000L),
				new Employee(495, "Test", "SOCIAL", 600000L));
		return list;
	}
}
