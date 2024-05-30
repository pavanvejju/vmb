package com.vmb.enterprise.langpack;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringReverse
{
    static int i,c=0,res;
    
    static void stringreverse(String s)
    {
    	int i,c;
    	String str	="";
    	for(i=s.length()-1,c=0;i>s.length()-i;i--,c++){
    		char ch[]=new char[s.length()];
    		ch[c]=s.charAt(i);
    		str += ch[c];
    	}
    	System.out.println(str);
    }
    
    public static void main (String args[])
    {
        StringReverse.stringreverse(" manchester united is also known as red devil ");
        
    }
}