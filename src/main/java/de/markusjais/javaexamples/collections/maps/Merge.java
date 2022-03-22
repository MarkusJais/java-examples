package de.markusjais.javaexamples.collections.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Merge {

    private static final List<String> WORDS_1 = List.of("puma", "tiger", "lion", "leopard", "puma", "lion", "tiger", "tiger");
    private static final List<String> WORDS_2 = List.of("cheetah", "bobcat", "puma", "tiger", "bobcat", "puma", "bobcat");

    public static void main(String[] args) {

        var map_1 = WORDS_1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var map_2 = new HashMap<String, Long>();
        for (String s : WORDS_2) {
            map_2.merge(s, 1L, Long::sum);
        }
        System.out.println(map_1);
        System.out.println(map_2);

        var map_3 = new HashMap<String, Long>(map_1);
        map_2.forEach((k, v) -> map_3.merge(k, v, Long::sum));
        System.out.println(map_3);

        Map<String, Long> map_4 = Stream.concat(map_1.entrySet().stream(), map_2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Long::sum));
        System.out.println(map_4);
    }
}
