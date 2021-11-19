package com.markusjais.javaexamples.concurrency.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.markusjais.javaexamples.concurrency.SleepUtils.sleepExactlyMilliseconds;

public class CompletableFutureCompleteWithException {

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


    public static CompletableFuture<Integer> getLargeIntFuture() {
        sleepExactlyMilliseconds(50);
        var integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> getLargeInt() );

        System.out.println("B_E");
        integerCompletableFuture.completeExceptionally(new Throwable("exception"));
        System.out.println("A_E");
        return integerCompletableFuture;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> intFuture = getLargeIntFuture();
        Integer result = intFuture.get();
        System.out.println("result:" + result);
    }
}
