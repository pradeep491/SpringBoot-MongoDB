package com.test;

import java.util.*;

public class Student implements Comparable<Student> {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public int compareTo(Student s) {
        return name.compareTo(s.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Viru"));
        list.add(new Student("Saurav"));
        list.add(new Student("Mukesh"));
        list.add(new Student("Tahir"));

        Collections.sort(list);

        for(Student s:list){
            System.out.println(s.name);
        }
    }
}
