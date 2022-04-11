package com.vmb.enterprise.langpack;

public class StringtoInt {
    
    
    public static void main (String args[])
    {
        String  convertingString="-123456";
        int output=    stringToint( convertingString );
        System.out.println("int value as output "+ output);
    }
    
    public static int stringToint( String str ){
        int i = 0, number = 0;
       boolean isNegative = false;
        int len = str.length();
       
        if( str.charAt(0) == '-' ){
            isNegative = true;
            i = 1;
        }
    	
        while(i<len){
        	number = number*10;
        	char character	=	(char) (str.charAt(i++) -'0');
        	number	=	number+ character;
        	System.out.println(number);
        }
        if( isNegative )
            number = -number;
        
    	return number;
    }   
}