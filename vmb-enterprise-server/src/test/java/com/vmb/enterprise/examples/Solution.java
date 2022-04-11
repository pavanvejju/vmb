package com.vmb.enterprise.examples;

import java.util.Arrays;

public class Solution {

    public static void main(String args[] ) throws Exception {

        String input = "ta1s2te the th34under";
        String[] inputarray = input.split(" ");

      Arrays.stream(inputarray).map(str -> 
      {
        String[] stringarr = (str.replaceAll("[^-?0-9]+", " ")!="" && str.replaceAll("[^-?0-9]+", " ")!="") ? str.replaceAll("[^-?0-9]+", " ").trim().split(" "):null;
        try {
        	int[] intarray	=	 Arrays.stream(stringarr).mapToInt(val-> (val!="" ? Integer.parseInt(val):0)).toArray();
        	int result	=   intarray!=null ? Arrays.stream(intarray).reduce((i,j) -> i+j).getAsInt():0;
        	return result;
        }catch(Exception e) {
        	return 0;
        }
      }).forEach( sum -> System.out.println("SUM::"+sum));
   
}

   
}