package de.markusjais.javaexamples.functional;


import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

record Country(String name){}


public class SupplierAndConsumerExample {

    public static void main(String[] args) {
        printCountry(() -> new Country("Spain"));


        System.out.println("\nConsumer output:");
        Consumer<Set<Country>>
                printSet = set -> set.forEach(System.out::println);
        var countries = Set.of(new Country("Italy"), new Country("France"));
        printSet.accept(countries);
    }

    private static void printCountry(Supplier<Country> countrySupplier) {
        System.out.println("Supplier output:");
        System.out.println(countrySupplier.get());
    }
}



