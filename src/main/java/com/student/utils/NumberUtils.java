package com.student.utils;

import java.util.Random;

public class NumberUtils {
	
	/**
	 * 生成随机短信验证码
	 */
	public static String getMessageNum(int length){
		StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for(int i=0;i<length;i++){
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num)+""), "");
        }
        return sb.toString();
	}
	
}
