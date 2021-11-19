package com.markusjais.javaexamples.concurrency.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.markusjais.javaexamples.concurrency.SleepUtils.sleepExactlyMilliseconds;
import static com.markusjais.javaexamples.concurrency.SleepUtils.sleepUpToMilliseconds;

public class CompletableFutureThenAccept {

    public static Integer getInt() {
        System.out.println("Thread getInt: " + Thread.currentThread());
        return 2;
    }

    public static void printInt(Integer i) {
        System.out.println("Thread printInt: " + Thread.currentThread());
        System.out.println("int:" + i);
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Thread main: " + Thread.currentThread());
        CompletableFuture<Integer> intFuture
                = CompletableFuture.supplyAsync(() -> getInt());
        intFuture
                .thenAccept(x -> printInt(x))
                .thenRun(() -> System.out.println("theRun"));

    }
}
