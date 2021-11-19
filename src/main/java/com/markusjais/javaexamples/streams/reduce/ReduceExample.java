package com.markusjais.javaexamples.streams.reduce;

import java.util.List;

record Book(String title, double priceInEuros) {
}

/**
 * shows how to use reduce to compute the sum of Book items in a list.
 *
 * In many cases, the sum can be computed with the "sum" method if it's a numeric stream like DoubleStream or IntStream
 *
 * Using "sum" makes the code shorter and easier to understand
 *
 * "reduce" is more powerful because it works with all data types, not just with numbers
 */
public class ReduceExample {

    public static void main(String[] args) {

        var books = List.of(
                new Book("book_1", 10.00),
                new Book("book_2", 20.00),
                new Book("book_3", 30.00),
                new Book("book_4", 40.00),
                new Book("book_5", 50.00)
                );

        double totalPriceWithReduce = books.stream().map(Book::priceInEuros).reduce(0.0, Double::sum);
        double totalPriceWithSum = books.stream().mapToDouble(Book::priceInEuros).sum();
        System.out.println("total price with reduce:" + totalPriceWithReduce);
        System.out.println("total price with sum:" + totalPriceWithSum);
    }
}
