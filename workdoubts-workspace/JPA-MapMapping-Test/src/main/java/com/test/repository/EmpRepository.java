package com.test.repository;

import com.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee,Integer> {
}
