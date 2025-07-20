package com.test.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable> {

	@Query("select s from Student s where s.name = ?1")
	public List<Student> findStudents(String name);

	@Query(value = "select * from Student2 s where s.name = ?1", nativeQuery = true)
	public List<Student> findStudentsUsingNativeQuery(String name);
}
