package com.markusjais.javaexamples.streams.flatmap;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * simple flatmap example
 * using map instead of flatMap would result in 2 stream objects instead of a list of strings
 */
public class FlatMapArrays {

    public static void main(String[] args) throws IOException {

        String str1 = "one two three four five";
        String str2 = "uno dos tres cuatro cinco";
        List<String> stringList = List.of(str1, str2);

        stringList.stream()
                .flatMap(s -> Stream.of(s.split(" ")))
                .forEach(System.out::println);
    }
}

