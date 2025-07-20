package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();
        list.add(new Student2(101, "Vijay", 23));
        list.add(new Student2(106, "Ajay", 27));
        list.add(new Student2(105, "Jai", 21));

        System.out.println("Sorting by Age");
        Collections.sort(list, new AgeComparator());
        for (Student2 s : list) {
            System.out.println(s);
        }
        System.out.println("Sorting by Name");
        Collections.sort(list, new NameComparator());
        for (Student2 s : list) {
            System.out.println(s);
        }
    }
}
