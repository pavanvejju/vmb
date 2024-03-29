package com.vmb.enterprise.datastructure;

/**
 * @author pavanvejju
 *
 */
public class FibonacciSeries {

    public static void printFibonacci(int n){
        int one = 0;
        int two = 1;
        System.out.println("First " + n + " elements in fibonacci series are: ");
        for (int i = 0; i <n ; i++) {
            System.out.print(one + " ");
            int temp = one + two;
            one = two;
            two = temp;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        printFibonacci(n);
    }
}