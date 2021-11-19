package com.markusjais.javaexamples.collections.lists;


import java.util.List;

/**
 * shows how to use "toList()" on streams. This method was added with Java 16.
 */
public class ToListExample {

    public static void main(String[] args) {
        var cats = List.of("tiger",  "puma", "leopard");
        var catsUpperCase = cats.stream().map(String::toUpperCase).toList();
        System.out.println(catsUpperCase);
    }
}
