package de.markusjais.javaexamples.concurrency.futures;

import de.markusjais.javaexamples.concurrency.SleepUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCompleteWithException {

    public static Integer getInt() {
        SleepUtils.sleepExactlyMilliseconds(1000);
        if (System.currentTimeMillis() % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    public static Integer getLargeInt() {
        SleepUtils.sleepExactlyMilliseconds(50);
        if (System.currentTimeMillis() % 2 == 0) {
            return 2_000;
        } else {
            return 1_000;
        }
    }


    public static CompletableFuture<Integer> getLargeIntFuture() {
        SleepUtils.sleepExactlyMilliseconds(50);
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
