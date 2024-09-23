package com.vmb.enterprise.langpack.java8;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class Base64Enc {

	public static void main(String[] args) {

		String normalString	=	"username:password";
		Base64.Encoder encoder	=	Base64.getEncoder();
		String encodedStr	=	encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		System.out.println("EncodedStr::"+encodedStr);
		
		Base64.Decoder decoder	=	Base64.getDecoder();
		byte[] decodedStr	=	decoder.decode(encodedStr);
		System.out.println("decodedStr::"+new String(decodedStr));
	}
}
