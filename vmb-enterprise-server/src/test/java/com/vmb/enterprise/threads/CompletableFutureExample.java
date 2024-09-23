package com.vmb.enterprise.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
* From here, we need to learn about
* CompletableFuture.supplyAsync starts an asynchronous task.
* thenApply ==> consumes the result and transform the result
* thenAccept ==> consumes the result and will not return the result
* thenRun ==>  executes a Runnable that prints "Computation finished!" after the future completes.
* */
public class CompletableFutureExample {
    public static void main(String[] args) {
        // Create a CompletableFuture that supplies a value asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello, World!";
        });

        // Apply a function to the result asynchronously
        // Process the result asynchronously
        CompletableFuture<Integer> futureLength = future.thenApplyAsync(String::length);

        // Accept the final result asynchronously
        futureLength.thenAcceptAsync(length -> {
            System.out.println("The length of the string is: " + length);
        });

        // Run a final action using thenRun
        futureLength.thenRun(() -> {
            System.out.println("Computation finished!");
        });
        // To ensure the main thread waits for the completion
        try {
            futureLength.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

