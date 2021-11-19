package com.markusjais.javaexamples.functional;

@FunctionalInterface
interface CalculatorFunctionalInterface {
    int calculate(int number);

    default int increment(int number) {
        return number + 1;
    }
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        int newValue = compute(4, x -> x * 10);
        System.out.println("new value: " + newValue);
    }

    private static int compute(int i, CalculatorFunctionalInterface c) {
        return c.calculate(i);
    }
}