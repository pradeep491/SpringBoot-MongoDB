package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NullFirstEx {
    public static void main(String[] args) {
        List<Student2> al = new ArrayList<Student2>();
        al.add(new Student2(101, "Vijay", 23));
        al.add(new Student2(106, "Ajay", 27));
        al.add(new Student2(105, null, 21));

        System.out.println("Sorting by Age...!");
        Comparator<Student2> cm1 = Comparator.comparing(Student2::getName, Comparator.nullsFirst(String::compareTo));
        Collections.sort(al, cm1);
        for (Student2 s : al) {
            System.out.println(s);
        }
        System.out.println("Sorting by name...!");
        Comparator<Student2> cm2 = Comparator.comparing(Student2::getName, Comparator.nullsLast(String::compareTo));
        Collections.sort(al, cm2);
        for (Student2 s1 : al) {
            System.out.println(s1);
        }

    }
}
