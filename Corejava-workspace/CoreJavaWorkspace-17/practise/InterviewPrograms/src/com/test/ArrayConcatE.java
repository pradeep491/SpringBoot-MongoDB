package com.test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayConcatE {
public static void main(String[] args) {
	int a[] = {1,2,3,4,5};
	int b[] = {6,7,8,9};
	int c[] = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
	System.out.println(Arrays.toString(c));
}
}
