package com.nexvid.testers;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTest
{
	public static void main(String[] args)
	{
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(1,1,24);
		cal2.set(1,1,16);
		Date tempDate1 = cal1.getTime();
		Date tempDate2 = cal2.getTime();
		java.sql.Date databaseDate = new java.sql.Date(tempDate1.getTime());
		java.sql.Date databaseDate2 = new java.sql.Date(tempDate2.getTime());
		
		Date testDate1 = databaseDate.valueOf(databaseDate.toString());
		Date testDate2 = databaseDate.valueOf(databaseDate2.toString());
		
		System.out.println(testDate1);
		System.out.println(testDate2);
		
		long testValue = getDateDiff(testDate1, testDate2, TimeUnit.DAYS);
		System.out.println("The difference in time is "+ testValue + " days");
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit time)
	{
		long diffInTime = date2.getTime() - date1.getTime();
		return time.convert(diffInTime, TimeUnit.MILLISECONDS);
	}
}
