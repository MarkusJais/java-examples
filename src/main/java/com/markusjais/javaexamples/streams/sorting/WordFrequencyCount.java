package com.markusjais.javaexamples.streams.sorting;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * sorts words in a text by frequency.
 * the most common words are printed first
 */
public class WordFrequencyCount {

    public static void main(String[] args) throws IOException {

        // removed a dash, otherwise it's the text from "A Tale of Two Cities" by Charles Dickens
        String textByCharlesDickens = """
                It was the best of times, it was the worst of times,
                it was the age of wisdom, it was the age of foolishness,
                it was the epoch of belief, it was the epoch of incredulity,
                it was the season of Light, it was the season of Darkness,
                it was the spring of hope, it was the winter of despair,
                we had everything before us, we had nothing before us,
                we were all going direct to Heaven, we were all going direct the other way
                in short, the period was so far like the present period,
                that some of its noisiest authorities insisted on its being received,
                for good or for evil, in the superlative degree of comparison only.
                """;

        textByCharlesDickens.lines()
                .flatMap(s -> Stream.of(s.split("([,.])|\\s+")))
                .collect(Collectors.groupingBy(
                        String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .filter( k -> !k.getKey().isEmpty())
                .map(entry -> String.format("%-15s: %s", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
