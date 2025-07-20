package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        List<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        //Java 8 Map() : Get names of all institutes
        List<String> namesOfInstitutes = instituteList.stream().map(Institute::getName).toList();
        System.out.println(namesOfInstitutes);

        //Java 8 FlatMap() : Get unique locations of all institutes
        Set<String> locationsOfInstitutes = instituteList.stream().flatMap(institute -> institute.getLocations().stream()).collect(Collectors.toSet());
        System.out.println(locationsOfInstitutes);
    }
}
