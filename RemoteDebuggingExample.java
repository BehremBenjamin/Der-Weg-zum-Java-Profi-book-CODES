package org.example;

import java.util.concurrent.TimeUnit;

public class RemoteDebuggingExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 50; i++) print(i);
    }

    public static void print (final int i) throws InterruptedException {
        System.out.println("i = " + i);
        TimeUnit.SECONDS.sleep(10);
    }
}
