package com.markusjais.javaexamples.patternmatching;

// supertype of all objects in the structure
sealed interface Animal permits Bird, Mammal {
}

record Bird(String name, int wingspanInCm) implements Animal {
}

record Mammal(String mame, int weightInKg) implements Animal {
}


public class PatternMatchingDemo {

    public static void main(final String[] args) {
        Animal bike = new Bird("Golden Eagle", 230);
        print(bike);
    }

    private static void print(Animal animal) {
        String toPrint = switch (animal) {
            case Bird body -> "it's a bird";
            case Mammal engine -> "it's a mammal";
        };

        System.out.println (toPrint);
    }

}


