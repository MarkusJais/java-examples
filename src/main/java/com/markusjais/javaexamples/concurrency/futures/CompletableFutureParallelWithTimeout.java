package com.markusjais.javaexamples.concurrency.futures;

import com.markusjais.javaexamples.concurrency.SleepUtils;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

record Cat(String name) {
}

record Dog(String name) {
}

record Titan(String name) {
}

class Zoo {
    public Dog dog;
    public Cat cat;
    public Titan titan;
}

public class CompletableFutureParallelWithTimeout {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        mixedGet();

    }

    private static void mixedGet() throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        var f1 = getString(1000);

        var f2 = f1.thenCompose(s -> getDog(s));
        var f3 = f1.thenCompose(s -> getCat(s));
        var f4 = f1.thenCompose(s -> getTitan(s));

        try {
            var allF = CompletableFuture.allOf(f2, f3, f4).get(3000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("it took:" + (System.currentTimeMillis() - start));

        var dog = f2.get();
        var cat = f3.get();
        var titan = f4.get();

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(titan);

    }

    private static CompletableFuture<String> getString(long millis) {
        SleepUtils.sleepExactlyMilliseconds(millis);
        System.out.println("UD: " + Thread.currentThread().getName() + "  ::" + LocalDateTime.now());
        return CompletableFuture.supplyAsync(() -> "animal:".toUpperCase());
    }

    private static CompletableFuture<Dog> getDog(String s) {
        return CompletableFuture.supplyAsync(() -> updateDog(new Dog(s + "_dog"), 1000));
    }

    private static CompletableFuture<Cat> getCat(String s) {
        return CompletableFuture.supplyAsync(() -> updateCat(new Cat(s + "_gato"), 2000));
    }

    private static CompletableFuture<Titan> getTitan(String s) {
        return CompletableFuture.supplyAsync(() -> updateTitan(new Titan(s + "_Godzilla"), 3000));
    }


    private static Dog updateDog(Dog dog, long millis) {
        SleepUtils.sleepExactlyMilliseconds(millis);
        System.out.println("UD: " + Thread.currentThread().getName() + "  ::" + LocalDateTime.now());
        return new Dog(dog.name().toLowerCase());
    }

    private static Cat updateCat(Cat cat, long millis) {
        SleepUtils.sleepExactlyMilliseconds(millis);
        System.out.println("UC: " + Thread.currentThread().getName() + "  ::" + LocalDateTime.now());
        return cat;
    }

    private static Titan updateTitan(Titan titan, long millis) {
        SleepUtils.sleepExactlyMilliseconds(millis);
        System.out.println("UT: " + Thread.currentThread().getName() + "  ::" + LocalDateTime.now());
        if (titan.name().contains("Godzilla")) {
            return new Titan(titan.name().toUpperCase());
        } else {
            return titan;
        }
    }
}

