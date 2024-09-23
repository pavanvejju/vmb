package com.vmb.enterprise.langpack.java17;

public class SwitchExample {

    public static void main(String... args){
        System.out.println("no of Days:::"+noOfDays("JANUARY"));
    }

    public static int noOfDays(String month){
        return switch(month) {
            case "JANUARY", "MARCH","May","JULY","AUGUST","OCTOBER","DECEMBER"  -> 31;
            case "FEBRUARY" -> 28;
            case "APRIL", "JUNE","SEPTEMBER","NOVEMBER" -> 30;
            default -> 0;
        };
    }

}
