package de.markusjais.javaexamples.concurrency.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFutureThenCompose {
    public static void main(String[] args) {
        var rndNumCompletableFuture = CompletableFuture
                .supplyAsync(() ->
                    ThreadLocalRandom.current().nextInt(1, 5));

        var composedCompletableFuture =
                rndNumCompletableFuture.thenCompose(CompletableFutureThenCompose::getMultipliedCompletableFuture);
        var power = composedCompletableFuture.join();
        System.out.println("result: " + power);
    }

    private static CompletableFuture<Integer> getMultipliedCompletableFuture(Integer x) {
        return CompletableFuture
                .supplyAsync(() ->
                    ThreadLocalRandom.current().nextInt(5, 10));
    }
}

