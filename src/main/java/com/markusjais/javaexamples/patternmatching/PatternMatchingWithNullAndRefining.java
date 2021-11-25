package com.markusjais.javaexamples.patternmatching;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatternMatchingWithNullAndRefining {

    public static void main(final String[] args) {

        printStuff("Java");
        printStuff("Python");
        printStuff(42);
        printStuff(null);
    }

    private static void printStuff(Object obj) {
        switch (obj) {
            case null  -> System.out.println("Dude, what are you doing?");
            case String s && s.equals("Java") -> System.out.println("good boy!");
            case String s -> System.out.printf("use Java, not %s\n", s);
            default        -> System.out.println("not a String");
        };
    }

}


