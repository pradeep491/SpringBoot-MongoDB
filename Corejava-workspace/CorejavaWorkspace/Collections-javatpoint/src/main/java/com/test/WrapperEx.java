package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WrapperEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(120));
        list.add(Integer.valueOf(150));
        list.add(Integer.valueOf(230));
        list.add(340);

        Collections.sort(list);

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
