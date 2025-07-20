package com.test;

public class Student1 implements Comparable<Student1> {
    int rollno;
    String name;
    int age;

    public Student1(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student1 s) {
        if (age == s.age) {
            return 0;
        } else if (age > s.age) {
            return 1;
        } else {
            return -1;
        }
    }
}
