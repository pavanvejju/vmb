package com.vmb.enterprise.langpack.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Base64Example1 {

	public static void main(String[] args) {

		
		
		String normalString = "username:password";
		byte[] byteEncodeArray	=	 normalString.getBytes(StandardCharsets.UTF_8);
		
		Base64.Encoder	encoder	=	Base64.getEncoder();
		String encodedString = encoder.encodeToString(byteEncodeArray);
		System.out.println(encodedString);
		
		
		
		Base64.Decoder decoder	=	Base64.getDecoder();
		byte[] decodeBytes	=	decoder.decode(encodedString);
		System.out.println(new String(decodeBytes));
		
		
		
	}

}
