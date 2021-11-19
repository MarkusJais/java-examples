package com.markusjais.javaexamples.records;

record Bird(String name, int weightInGrams, int wingspanInCm) {
}

/**
 * demonstrates the simple use of a record
 */
public class BirdRecordExample {
    public static void main(String[] args) {
        var goldenEagle = new Bird("Golden Eagle", 5500, 230);
        System.out.println(goldenEagle);
    }
}
