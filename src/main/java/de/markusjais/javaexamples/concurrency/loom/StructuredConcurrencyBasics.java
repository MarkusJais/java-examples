package de.markusjais.javaexamples.concurrency.loom;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StructuredConcurrencyBasics {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Result:" + getResult());
    }


    private static int getResult() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            // can be a method reference
            Future<Integer> intFuture_1  = scope.fork(StructuredConcurrencyBasics::getRandomInt);

            // can be a lambda
            Future<Integer> intFuture_2 = scope.fork(() -> getRandomInt());

            scope.join();
            scope.throwIfFailed();

            // this should always succeed, so we just return the results
            return intFuture_1.resultNow() + intFuture_2.resultNow();
        }
    }

    private static Integer getRandomInt() {
        var random = new Random();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return random.nextInt(100);
    }
}

