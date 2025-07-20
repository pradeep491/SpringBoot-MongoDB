package com.test;

import java.util.Comparator;

public class AgeComparator implements Comparator{
    public int compare(Object o1, Object o2) {
        Student2 s1 = (Student2)o1;
        Student2 s2 = (Student2)o2;
        if (s1.age == s2.age) {
            return 0;
        } else if (s1.age > s2.age) {
            return 1;
        } else {
            return -1;
        }
    }
}
