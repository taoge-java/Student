package com.student.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 密码加密方法
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年4月22日 下午5:03:55
 */
public class EncryptUtils {

	/**
	 * 先对密码进行md5加密，然后在使用加密后的字符串+SALT组合MD5再次加密，在对组合的字符串进行md5加密
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String encodePassword(String password,String salt){
		String str=DigestUtils.md5Hex(password)+salt;
		return DigestUtils.md5Hex(str);
	}
}
