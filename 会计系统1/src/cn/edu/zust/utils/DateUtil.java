package cn.edu.zust.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	
	public static String getCurrentDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss");
		String currentDateTime = sdf.format(new Date());
		return currentDateTime;
	}
	public static String getCurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currentDate = sdf.format(new Date());
		return currentDate;
	}
	
	
}
