package com.markusjais.javaexamples.concurrency.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.markusjais.javaexamples.concurrency.SleepUtils.*;
import static com.markusjais.javaexamples.concurrency.SleepUtils.sleepUpToMilliseconds;

public class CompletableFutureThenApply {

    public static String getStringEven() {
        sleepUpToMilliseconds(100);
        return "even";
    }

    public static String getStringOdd() {
        sleepUpToMilliseconds(500);
        return "odd";
    }


    public static Integer getInt() {
        System.out.println("sleeping");
        sleepExactlyMilliseconds(5000);
        if (System.currentTimeMillis() % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    public static Double getSeparator() {
        if (System.currentTimeMillis() % 2 == 0) {
            return 2.2;
        } else {
            return 1.1;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> intFuture
                = CompletableFuture.supplyAsync(() -> getInt());

        CompletableFuture<String> stringFuture = intFuture
                .thenApply(i -> { // getStringForInt(i));
                    System.out.println("i:" + i);
                    if (i % 2 == 0) {
                        return getStringEven();
                    } else {
                        return getStringOdd();
                    }
                });

        String result = stringFuture.get();
        System.out.println("result:" + result);
    }
}
