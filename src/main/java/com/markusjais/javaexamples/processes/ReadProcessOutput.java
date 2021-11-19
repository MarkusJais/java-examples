package com.markusjais.javaexamples.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Example to show how to execute a Linux process
 * In production code, you would not call the "date" command but use the java datetime API to get the current date
 * and time
 */

public class ReadProcessOutput {

    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime()
                .exec("date");
        var br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String output = br.readLine();
        System.out.println("Date and Time: " + output);
    }
}
