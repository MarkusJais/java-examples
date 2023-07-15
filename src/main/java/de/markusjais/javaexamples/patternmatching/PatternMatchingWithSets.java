package de.markusjais.javaexamples.patternmatching;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatternMatchingWithSets {

    public static void main(final String[] args) {
        var hashSet = Stream.of("one", "two", "three")
                .collect(Collectors.toCollection(HashSet::new));
        var treeSet = Stream.of("uno", "does", "tres")
                .collect(Collectors.toCollection(TreeSet::new));
        var immutableSet = Set.of("Puma", "Tiger", "Leopard");

        System.out.println(whichSetAreYou(hashSet));
        System.out.println(whichSetAreYou(treeSet));
        System.out.println(whichSetAreYou(immutableSet));

    }

    private static String whichSetAreYou(Set<String> set) {
        return switch (set) {
            case HashSet<String> h -> String.join(", ", h);
            case TreeSet<String> h -> String.join(":", h);
            case Set<String> h -> String.join("#", h);
        };
    }

}


