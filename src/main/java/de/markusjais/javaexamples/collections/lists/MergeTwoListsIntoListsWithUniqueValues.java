package de.markusjais.javaexamples.collections.lists;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.toSet;

/**
 * Shows how to merge two lists into a new list with duplicated values removed
 *
 * An alternative would be to merge the lists into a set, which would automatically remove duplicates and
 * would not need the call to "distinct". But sometimes a list is needed, e.g. to pass it to another methods which
 * expects a list.
 */
public class MergeTwoListsIntoListsWithUniqueValues {

    public static void main(String[] args) {
        var listOne = List.of("A", "B", "C", "A");
        var listTwo = List.of("B", "E", "Z");

        var uniqueValues = Stream.of(listOne.stream(), listTwo.stream())
                .flatMap(e -> e)
                .distinct()
                .toList();
        System.out.println(uniqueValues);
    }
}
