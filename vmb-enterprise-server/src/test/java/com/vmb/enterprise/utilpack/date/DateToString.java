package com.vmb.enterprise.utilpack.date;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {

	public static void main(String[] args) throws ParseException {
 
		String strdate	=	"01-01-2014";
		DateFormat	df	=	new SimpleDateFormat("dd-MM-yyyy");
		Date d1	=	df.parse(strdate);
		String dateStr	=	df.format(d1);
		System.out.println(dateStr);
		
		DateFormatSymbols dfs	=	new DateFormatSymbols();
		String[] monthNames	=	dfs.getShortMonths();
		System.out.println();
		for(String monthName: monthNames){
			System.out.println(monthName);
			
		}
	}

}
