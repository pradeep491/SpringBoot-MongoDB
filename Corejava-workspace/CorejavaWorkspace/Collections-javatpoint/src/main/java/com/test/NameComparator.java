package com.test;

import java.util.Comparator;

public class NameComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Student2 s1 = (Student2)o1;
        Student2 s2 = (Student2)o2;
        return s1.name.compareTo(s2.name);
    }
}
