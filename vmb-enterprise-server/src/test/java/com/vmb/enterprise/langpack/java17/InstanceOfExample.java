package com.vmb.enterprise.langpack.java17;

public class InstanceOfExample {

    public static void main(String... args) {

        Object obj = 42;

        extracted(obj);
    }

    private static void extracted(Object obj) {
        if(obj instanceof String str){
            System.out.println("It's a string: " + str);
        } else if (obj instanceof Integer i) {
            System.out.println("It's an integer: " + i);
        } else if (obj instanceof Boolean b) {
            System.out.println("It's a boolean: " + b);
        } else{
            System.out.println("Unknown type");
        }
    }
}
