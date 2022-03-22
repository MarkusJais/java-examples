package de.markusjais.javaexamples.concurrency.futures;

import de.markusjais.javaexamples.concurrency.SleepUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureParallel {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //withCompose();
        System.out.println("=========================");
        inParallelJoin();
        System.out.println("----------------------------");
        mixedJoin();
        System.out.println("*****************************");
        mixedGet();
    }

    private static void mixedGet() throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        var f1 = get_1("A");

        var f2 = f1.thenCompose(s -> get_2(s));
        var f3 = f1.thenCompose(s -> get_3(s));
        var f4 = f1.thenCompose(s -> get_4(s));

        String s2 = f2.get();
        String s3 = f3.get();
        String s4 = f4.get();

        System.out.println("mixedGet:" + s2 + ":"+ s3 + ":" + s4);
        System.out.println("it took:" + (System.currentTimeMillis() - start));

    }


    private static void mixedJoin() throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        var f1 = get_1("A");

        var f2 = f1.thenCompose(s -> get_2(s));
        var f3 = f1.thenCompose(s -> get_3(s));
        var f4 = f1.thenCompose(s -> get_4(s));

        String mixed = Stream.of(f2, f3, f4)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println("mixed:" + mixed);
        System.out.println("it took:" + (System.currentTimeMillis() - start));

    }

    private static void inParallelJoin() throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        var f1 = get_1("A");

        var f2 = get_2("B");
        var f3 = get_3("C");
        var f4 = get_4("D");

        String parallel = Stream.of(f1, f2, f3, f4)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println("Combined:" + parallel);
        System.out.println("it took:" + (System.currentTimeMillis() - start));

    }

    private static void withCompose() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        var f1 = get_1("A");

        var f2 = f1.thenCompose(s -> get_2(s))
                .thenCompose(s -> get_3(s))
                .thenCompose(s -> get_4(s));

        System.out.println("result: " + f2.get());
        System.out.println("it took:" + (System.currentTimeMillis() - start));
    }


    private static CompletableFuture<String> get_1(String s) {
        return  CompletableFuture.supplyAsync(() -> getStr(s + ":" + "1", 0));
    }

    private static CompletableFuture<String> get_2(String s) {
        return  CompletableFuture.supplyAsync(() -> getStr(s + ":" + "2", 500));
    }

    private static CompletableFuture<String> get_3(String s) {
        return  CompletableFuture.supplyAsync(() -> getStr(s + ":" + "3", 1200));
    }

    private static CompletableFuture<String> get_4(String s) {
        return  CompletableFuture.supplyAsync(() -> getStr(s + ":" + "4", 800));
    }

    private static String getStr(String s, long millis) {
        SleepUtils.sleepExactlyMilliseconds(millis);
        System.out.println("G_" + s);
        SleepUtils.sleepExactlyMilliseconds(1000);
        System.out.println("G_" + s + "_a");
        return "S_" + s;
    }
}

