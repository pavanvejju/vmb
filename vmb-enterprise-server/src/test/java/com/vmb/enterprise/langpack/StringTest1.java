package com.vmb.enterprise.langpack;

public class StringTest1 {

	public static void main(String[] args) {

		String str = "TestTestTestTestTestTestTestTestTestTestTest";
		String dupStr = "";
		for (int i = 0; i < str.length(); i++) {
			dupStr += str.charAt(i);
			if (str.replaceAll(dupStr, "").length() == 1) {
				str = dupStr;
				break;
			}
		}
		System.out.println(str);
	} 

}
