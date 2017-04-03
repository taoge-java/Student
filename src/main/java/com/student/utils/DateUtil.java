package com.student.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/***
	 * @author zjt
	 * 时间格式工具类
	 */
    public  static String getDateTime(){
		return  new  SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	public static Date getDay(){
		return new Date();
	}
}
