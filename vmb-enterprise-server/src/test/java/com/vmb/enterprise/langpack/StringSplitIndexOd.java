package com.vmb.enterprise.langpack;

public class StringSplitIndexOd {

	public static void main(String[] args) {

		String str	=	"(123((((456)";
		String finalStr	=	str.substring(1, str.length()-1);
		try {
			Long.parseLong(finalStr);
			
			System.out.println("VALID"); 
		}catch(Exception e) {
			//Long.parseLong(finalStr);
			System.out.println(finalStr+":NOt VALID"+e);
		}finally {
			System.out.println("Testing successfull");
		}
		
	}
}
