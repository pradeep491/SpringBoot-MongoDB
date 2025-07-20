package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMainJava8 {
    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();
        list.add(new Student2(101, "Vijay", 23));
        list.add(new Student2(106, "Ajay", 27));
        list.add(new Student2(105, "Jai", 21));

        System.out.println("Sorting by Age");
        Comparator<Student2> cm1 = Comparator.comparing(Student2::getAge);
        Collections.sort(list,cm1);
        for (Student2 s : list) {
            System.out.println(s);
        }
        System.out.println("Sorting by Name");
        Comparator<Student2> cm2 = Comparator.comparing(Student2::getName);
        Collections.sort(list,cm2);
        for (Student2 s : list) {
            System.out.println(s);
        }
    }
}
