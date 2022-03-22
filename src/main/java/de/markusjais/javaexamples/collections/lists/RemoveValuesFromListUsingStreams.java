package de.markusjais.javaexamples.collections.lists;


import java.util.List;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

/**
 * Remove all elements from one list from another list using streams
 *
 * An alternative could be Collection.removeAll but that requires mutable lists
 *
 * The method below only uses immutable lists
 */
public class RemoveValuesFromListUsingStreams {

    public static void main(String[] args) {
        var listOne = List.of("A", "B", "C", "A");
        var listTwo = List.of("B", "E", "Z");

        var result = listOne.stream()
                .filter(not(listTwo::contains))
                .toList();
        System.out.println(result);
    }
}
