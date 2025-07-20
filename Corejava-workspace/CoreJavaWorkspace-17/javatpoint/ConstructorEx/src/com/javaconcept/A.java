package com.javaconcept;
class B{
	public B() {
		
	}
}
public class A {
	A()
    {
         //By Default, Compile will keep super() calling statement here.
         System.out.println("First Constructor");
    }
    A(int i)
    {
         //Compiler will not keep any statement here
         super();
         System.out.println("Second Constructor");
    }
    A(int i, int j)
    {
         //Compiler will not keep any statement here
         this();
         System.out.println("Third Constructor");
    }
    A(int i, int j, int k)
    {
         System.out.println("Fourth Constructor");
          //super(); It will give error if you keep super() here
    }
}
