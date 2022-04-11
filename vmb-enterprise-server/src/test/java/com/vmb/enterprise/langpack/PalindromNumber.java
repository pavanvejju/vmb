package com.vmb.enterprise.langpack;

/**
 * @author pavankumarv
 *
 */

public class PalindromNumber {
	
	
	public static void main(String[] args) {
		String key	=	"MASAME";
		int flag=0;
		for(int i=0,j=key.length()-1; i<key.length()/2;i++,j--) {
			if(key.toCharArray()[i]!=key.toCharArray()[j]) {
				System.out.println(key+" is not a Pallindram");
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.println(key+" is a pallandrom");
		}
	}
}
