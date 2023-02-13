package com.vmb.enterprise.langpack.java8;

import java.util.Scanner;

public class ScannerString {

    public static void main(String[] args) {
    	 // creates an object of Scanner
       
    	 Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        double d = input.nextDouble();
        input.nextLine();
        String value = input.nextLine();
        System.out.println("Using next(): " + value);
       // If you use the nextLine() method immediately following the nextInt() method,
        // recall that nextInt() reads integer tokens; because of this, the last newline character for that line of integer input is still queued in the input buffer and the next nextLine() will be reading the remainder of the integer line (which is empty).
        

        input.close();
              
       
    }
}

