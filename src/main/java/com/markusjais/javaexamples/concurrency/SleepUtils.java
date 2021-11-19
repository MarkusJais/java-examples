package com.markusjais.javaexamples.concurrency;

import java.util.Random;

public class SleepUtils {

    public static void sleepUpToMilliseconds(int limit) {
        try {
            Thread.sleep(new Random().nextInt(limit));
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepExactlyMilliseconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}
