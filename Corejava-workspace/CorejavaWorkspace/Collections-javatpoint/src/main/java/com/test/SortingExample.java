package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Viru");
        list.add("Saurav");
        list.add("Mukesh");
        list.add("Tahir");
        Collections.sort(list);
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("Reverse Order");
        Collections.sort(list,Collections.reverseOrder());
        Iterator itr1 = list.iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
    }
}
