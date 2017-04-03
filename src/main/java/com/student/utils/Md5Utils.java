package com.student.utils;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;


public class Md5Utils {
	/**
	 * @author zjt
	 * 密码加密
	 * @return md5
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getMd5(String md5) throws NoSuchAlgorithmException{ 
		MessageDigest md=MessageDigest.getInstance("md5");
        byte[]  md5Byte=md.digest(md5.getBytes());
        return Hex.encodeHexString(md5Byte);
	}
	
	public static void main(String[] args) {
		try {
		   getDES("12345678");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DES加密算法
	 */
	public static void getDES(String des){
		//生成key
		try {
			KeyGenerator keygenerator=KeyGenerator.getInstance("DES");
			keygenerator.init(56);
			SecretKey secretkey = keygenerator.generateKey();
			byte[] bytes=secretkey.getEncoded();

			//key转换
		    DESKeySpec desedekeyspec=new DESKeySpec(bytes);
			SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");
		    Key key=factory.generateSecret(desedekeyspec);
				   
		    //加密
		    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5padding");
		    cipher.init(Cipher.ENCRYPT_MODE,key);
		    byte[] result= cipher.doFinal(des.getBytes());
		    System.out.println(Hex.encodeHexString(result));
		    
		    //解密
		    cipher.init(Cipher.DECRYPT_MODE, key);
		    result=cipher.doFinal(result);
		    System.out.println("解密"+new String(result));
		   // return  Hex.encodeHexString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 3重des加密算法
	 */
	
	public static void getJDK3des(String des){
		//生成key
				try {
					KeyGenerator keygenerator=KeyGenerator.getInstance("DESede");
					keygenerator.init(168);
					SecretKey secretkey = keygenerator.generateKey();
					byte[] bytes=secretkey.getEncoded();

					//key转换
				    DESedeKeySpec desedekeyspec=new DESedeKeySpec(bytes);
					SecretKeyFactory factory=SecretKeyFactory.getInstance("DESede");
				    Key key=factory.generateSecret(desedekeyspec);
						   
				    //加密
				    Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5padding");
				    cipher.init(Cipher.ENCRYPT_MODE,key);
				    byte[] result= cipher.doFinal(des.getBytes());
				    System.out.println(Hex.encodeHexString(result));
				    
				    //解密
				    cipher.init(Cipher.DECRYPT_MODE, key);
				    result=cipher.doFinal(result);
				    System.out.println("解密"+new String(result));
				   // return  Hex.encodeHexString(result);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	
	/***
	 * AES加密算法
	 */
	public static void getAES(String aes){
		//生成key
		try {
			KeyGenerator keygenerator=KeyGenerator.getInstance("AES");
			keygenerator.init(128);
			SecretKey secretkey=keygenerator.generateKey();
			byte[] bytes=secretkey.getEncoded();
		
		//key转换
			Key key=new SecretKeySpec(bytes, "AES");
		//加密
			Cipher cipher=	Cipher.getInstance("AES/ECB/PKCS5padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result=cipher.doFinal(aes.getBytes());
			 System.out.println(Hex.encodeHexString(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * PBE加密算法
	 */
	
	public static void getPBE(String pbe){
		SecureRandom securerandom =new SecureRandom();
	    byte[] bytes=securerandom.generateSeed(8);
	    
	    //口令密钥
	    String password="hello";
	    PBEKeySpec pbekeyspec =new PBEKeySpec(password.toCharArray());
	    try {
			SecretKeyFactory factory=SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key=factory.generateSecret(pbekeyspec);
			
			//加密
			PBEParameterSpec  pbeparameterspec=new PBEParameterSpec(bytes,100);
			Cipher cipher=	Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key,pbeparameterspec);
			byte[] result=cipher.doFinal(pbe.getBytes());
			System.out.println(Hex.encodeHexString(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
