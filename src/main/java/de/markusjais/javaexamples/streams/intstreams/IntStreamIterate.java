package de.markusjais.javaexamples.streams.intstreams;

import java.util.stream.IntStream;

/**
 * Shows how to use the iterate methods of an IntStream
 */
public class IntStreamIterate {

    public static void main(String[] args) {
        // sum of the first 10 even numbers
        int sum = IntStream.iterate(2, i -> i + 2)
                .limit(10)
                .sum();

        System.out.println("Sum is:" + sum);

        // sum of all the even numbers from 2 to 100
        int sum2 = IntStream.iterate(2,  i -> i <= 100, i -> i + 2)
                .sum();

        System.out.println("Sum 2 is: " + sum2);

    }
}
