package com.markusjais.javaexamples.concurrency.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.markusjais.javaexamples.concurrency.SleepUtils.sleepExactlyMilliseconds;

public class CompletableFutureThenCompose2 {

    public static Integer getInt() {
        sleepExactlyMilliseconds(1000);
        if (System.currentTimeMillis() % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    public static Integer getLargeInt() {
        sleepExactlyMilliseconds(50);
        if (System.currentTimeMillis() % 2 == 0) {
            return 2_000;
        } else {
            return 1_000;
        }
    }


    public static CompletableFuture<Integer> getLargeIntF(int p) {
        sleepExactlyMilliseconds(50);
        return CompletableFuture
                .supplyAsync(() -> getLargeInt() + p);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> intFuture
                = CompletableFuture.supplyAsync(() -> getInt());

        CompletableFuture<Integer> resultFuture =
                intFuture.thenCompose(p -> {
                    if (p == 1) {
                        return getLargeIntF(100);
                    } else {
                        return getLargeIntF(200);
                    }
                });

        Integer result = resultFuture.get();

        System.out.println("result:" + result);


    }
}
