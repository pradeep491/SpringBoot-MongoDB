package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student1Main {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<Student1>();
        list.add(new Student1(101,"Vijay",23));
        list.add(new Student1(106,"Ajay",27));
        list.add(new Student1(105,"Jai",21));

        Collections.sort(list,Collections.reverseOrder());
        for(Student1 s:list){
            System.out.println(s);
        }
    }
}
