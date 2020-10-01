package com.vmb.enterprise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegString {

	public static void main(String[] args) {
		String str = "ZZZZL <%= dsn %> AFFF <%= AFG %>";
		Pattern pattern = Pattern.compile("<%=(.*?)%>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
		    System.out.println(matcher.group(1));
		}
	}

}
