package com.markusjais.javaexamples.patternmatching;

// supertype of all objects in the structure
sealed interface Animal permits Bird, Mammal {
}

record Bird(String name, int wingspanInCm) implements Animal {
}

record Mammal(String mame, int weightInKg) implements Animal {
}


public class PatternMatchingWithSealedInterfacesAndRecords {

    public static void main(final String[] args) {
        Animal animal = new Bird("Golden Eagle", 230);
        print(animal);
    }

    private static void print(Animal animal) {
        String toPrint = switch (animal) {
            case Bird b -> "it's a bird: " + b.name();
            case Mammal m -> "it's a mammal and it weighs: " + m.weightInKg() + " kg";
        };
        System.out.println (toPrint);
    }
}


