package com.markusjais.javaexamples.records;

record Bird(String name, int weightInGrams, int wingspanInCm) {

    public String toString() {
        return String.format("%s:%s:%d", name, weightInGrams, wingspanInCm);
    }

    public Bird updateWeight(int newWeightInGrams) {
        return new Bird(name, newWeightInGrams, wingspanInCm);
    }
}

/**
 * demonstrates a simple use of a record
 */
public class BirdRecordExample {
    public static void main(String[] args) {
        var goldenEagle = new Bird("Golden Eagle", 5500, 230);
        System.out.println(goldenEagle);

        var heavyEagle = goldenEagle.updateWeight(6000);
        System.out.println(heavyEagle);

        var whiteTailedEagle = new Bird("White-tailed Eagle", 6000, 245);
        System.out.println("name of the sea eagle species:" + whiteTailedEagle.name());

    }
}
