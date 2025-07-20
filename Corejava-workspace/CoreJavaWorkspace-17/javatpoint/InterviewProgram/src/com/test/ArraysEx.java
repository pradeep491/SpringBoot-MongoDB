package com.test;

import java.util.Arrays;
import java.util.List;

public class ArraysEx {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 7,9, 6, 2, 1, 5, 3);//9,9,6,5,5,3,0
		int n = list.size();
		//int i,next;
		int a[] = new int[n];
		for(int i = 0;i<n;i++) {
			for(int j = i+1;j<list.size();j++) {
				if(list.get(i+1) < a[j+1]) {
					a[i] = a[j];
				}
			}
		}
		System.out.println(a);
	}
}
