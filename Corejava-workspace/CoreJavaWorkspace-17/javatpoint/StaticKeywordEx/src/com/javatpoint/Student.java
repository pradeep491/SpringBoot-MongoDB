package com.javatpoint;

public class Student {
	int id;
	String name;
	static String college = "N.I.E.T";

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	void display() {
		System.out.println(id + " " + name + " " + college);
	}

	public static void main(String[] args) {
		Student s = new Student(491, "pradeep");
		s.display();
	}
}
