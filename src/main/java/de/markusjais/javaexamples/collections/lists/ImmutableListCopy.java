package de.markusjais.javaexamples.collections.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * shows how to create an immutable copy of an existing list
 */
public class ImmutableListCopy {
    public static void main(String[] args) {
        var mutableList = new ArrayList<String>();
        mutableList.add("Java");
        mutableList.add("Rust");

        var immutableCopy = List.copyOf(mutableList);

        // this line results in a runtime exception: UnsupportedOperationException
        //immutableCopy.add("Python");

        // this works because the original list is an ArrayList which is mutable
        mutableList.add("Scala");

        System.out.println("mutable list: " + mutableList);
        System.out.println("immutable copy: " + immutableCopy);
    }
}
