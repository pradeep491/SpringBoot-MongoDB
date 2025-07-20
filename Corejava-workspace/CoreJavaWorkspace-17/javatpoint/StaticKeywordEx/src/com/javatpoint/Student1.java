package com.javatpoint;

public class Student1 {
	int id;
	String name;
	static String college = "N.I.E.T";

	Student1(int id, String name) {
		this.id = id;
		this.name = name;
	}

	void display() {
		System.out.println(id + " " + name + " " + college);
	}

	static void change() {
		college = "BDIT";
	}

	public static void main(String[] args) {
		Student1.change();
		Student1 s = new Student1(491, "pradeep");
		s.display();
	}
}
