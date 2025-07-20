package com.test;

interface Calculator {
	//void switchon();
	/* void sum(int input); */
	int substract(int i1,int i2);
}

public class CalculatorImpl {



	public static void main(String[] args) {
		//()     ->   {body}
		/*
		 * Calculator cal = () ->System.out.println("Switch On"); cal.switchon();
		 */
		
		/*
		 * Calculator cal = (int input)-> System.out.println("sum is-"+input);
		 * 
		 * cal.sum(10);
		 */
		
		/*
		 * Calculator cal = (input)-> System.out.println("sum is-"+input);
		 * cal.sum(10);
		 */
		//Calculator cal  = (i1,i2)->i1-i2;
		
		//to add any business logic
		Calculator cal  = (i1,i2)->{
			if(i2 > i1) {
				throw new RuntimeException("i2 must not be greter than i1");
			}else {
				return i1-i2;
			}
		};
		System.out.println(cal.substract(20,30));
	
	}
}
