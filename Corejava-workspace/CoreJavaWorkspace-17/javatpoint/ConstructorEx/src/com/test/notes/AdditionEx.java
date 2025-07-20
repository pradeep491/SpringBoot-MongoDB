package com.test.notes;

public class AdditionEx {
	int a, b;

	public AdditionEx(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public AdditionEx() {
		a = b = 0;
	}

	AdditionEx sum(AdditionEx x) {
		AdditionEx ax = new AdditionEx();
		ax.a = this.a + x.a;
		ax.b = this.b + x.b;
		return ax;
	}
	void disp() {
		System.out.println(a+" "+b);
	}
	public static void main(String[] args) {
		AdditionEx a = new AdditionEx(10,20);
		AdditionEx a2 = new AdditionEx(30,40);
		AdditionEx a3 = new AdditionEx();
		a3 = a.sum(a2);
		a.disp();
		a2.disp();
		a3.disp();
	}
}
