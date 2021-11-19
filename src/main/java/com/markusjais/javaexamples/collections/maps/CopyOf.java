package com.markusjais.javaexamples.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class CopyOf {

    public static void main(String[] args) {

        var catsAndWeight = Map.of("Tiger", 220, "Puma", 70, "Eurasian Lynx", 35, "Leopard", 60);

        var catsAndWeightCopy = Map.copyOf(catsAndWeight);

        var catsAndWeightMutable = new HashMap<String, Integer>();
        catsAndWeightMutable.put("Tiger", 220);
        catsAndWeightMutable.put("Puma", 70);
        catsAndWeightMutable.put("Eurasian Lynx", 35);
        catsAndWeightMutable.put("Leopard", 60);

        var catsAndWeightMutableCopyOf = Map.copyOf(catsAndWeightMutable);

        System.out.println(catsAndWeight.getClass().getName());
        System.out.println(catsAndWeightCopy.getClass().getName());
        System.out.println(catsAndWeightMutable.getClass().getName());
        System.out.println(catsAndWeightMutableCopyOf.getClass().getName());

        System.out.println(Integer.toHexString(System.identityHashCode(catsAndWeight)));
        System.out.println(Integer.toHexString(System.identityHashCode(catsAndWeightCopy)));
        System.out.println(Integer.toHexString(System.identityHashCode(catsAndWeightMutable)));
        System.out.println(Integer.toHexString(System.identityHashCode(catsAndWeightMutableCopyOf)));
    }
}
