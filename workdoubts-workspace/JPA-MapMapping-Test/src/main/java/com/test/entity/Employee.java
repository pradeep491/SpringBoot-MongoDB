package com.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Entity
@Setter
@Getter
@ToString
public class Employee {
    @Id
    private Long id;
    private String name;
    private String type;
    // Other attributes

    @ElementCollection
    @CollectionTable(name="employee_department",
            joinColumns=@JoinColumn(name="employee_id"))
    @MapKeyColumn(name="department_key")
    @Column(name="department_value")
    private Map<String,String> customMessages;
}
