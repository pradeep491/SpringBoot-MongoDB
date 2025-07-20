package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RetrieveLastElement {
public static void main(String[] args) {

    // Creating a list of strings
    List<String> strings = Arrays.asList("Java", "Python", "C++", "JavaScript", "Ruby");
    Optional<String> str = strings.stream().reduce((first,second)->second);
    str.ifPresent(n->System.out.println(n));
}
}
