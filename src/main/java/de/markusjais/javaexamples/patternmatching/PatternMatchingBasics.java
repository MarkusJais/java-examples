package de.markusjais.javaexamples.patternmatching;

import java.util.Set;

public class PatternMatchingBasics {

    public static void main(final String[] args) {
        System.out.println(whatAreYou(42));
        System.out.println(whatAreYou("Owl"));
        System.out.println(whatAreYou(Double.valueOf("0.42")));
        System.out.println(whatAreYou(Set.of("one", "two", "three")));
    }

    private static String whatAreYou(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("I'm an Integer with value: %d", i);
            case String s  -> String.format("I'm a String with value: %s", s);
            case Set set -> String.format("I'm a Set with values: %s ", String.join(", ", set));
            default        -> String.format("I think I am a %s", obj.getClass().getName());
        };
    }
}


