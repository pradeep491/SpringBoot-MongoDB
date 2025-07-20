package com.test;

import java.util.List;

public class TaxService {
	public static List<Employee> evaluateTaxPayers(String input) {
		/*
		 * if (input.equalsIgnoreCase("tax")) { return
		 * EmployeeDAO.getEmployees().stream().filter(emp -> emp.getSalary() >
		 * 500000L).toList(); } else { return
		 * EmployeeDAO.getEmployees().stream().filter(emp -> emp.getSalary() <
		 * 500000L).toList(); }
		 */
		return input.equalsIgnoreCase("tax")
				? EmployeeDAO.getEmployees().stream().filter(emp -> emp.getSalary() > 500000L).toList()
				: EmployeeDAO.getEmployees().stream().filter(emp -> emp.getSalary() < 500000L).toList();
	}

	public static void main(String[] args) {
		//System.out.println(evaluateTaxPayers("notax"));
		List<Employee> list = evaluateTaxPayers("tax");
		list.stream().forEach(obj->System.out.println(obj));
	}
}
