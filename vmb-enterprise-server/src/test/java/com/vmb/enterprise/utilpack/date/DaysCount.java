package com.vmb.enterprise.utilpack.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/*
 * Find out the no. of days in between two given dates
 * */
public class DaysCount {

	
	public static int getDays(String strd1,String strd2){
	     
	     Long dateTime1=0L;
	     Long dateTime2=0L;
		try {
			
			Calendar cal1 = new GregorianCalendar();
			Calendar cal2 = new GregorianCalendar();
		     
		     SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		     Date d1 = sdf.parse(strd1);
			cal1.setTime(d1);
			Date calTime1	=	cal1.getTime();
			dateTime1	=	calTime1.getTime();
			
			Date d2 = sdf.parse(strd2);
			cal2.setTime(d2);
			Date calTime2	=	cal2.getTime();
			dateTime2	=	calTime2.getTime();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	     
		return (int)((dateTime1-dateTime2)/(24*60*60*1000));
	}
	public static void main(String[] args) {
	
			int getdays	=	DaysCount.getDays("15122014", "01102014");
			System.out.println(getdays);
	}
}