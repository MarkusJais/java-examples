package com.markusjais.javaexamples.streams.map;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

record City(String name, String country) {
}

/**
 * Shows how to group a list of cities by their country
 */
public class MapGroupingByExample {

    public static Map<String, Set<String>> getCitiesByCountry(List<City> cities) {
        return cities.stream().collect(
                Collectors.groupingBy(City::country,  mapping(City::name,
                        toSet())));
    }

    public static void main(String[] args) {
        var cities = List.of(
                new City("Berlin", "Germany"),
                new City("London", "UK"),
                new City("Madrid", "Spain"),
                new City("Valencia", "Spain")
        );
        var result = getCitiesByCountry(cities);
        System.out.println(result);
    }
}
