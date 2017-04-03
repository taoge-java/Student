package com.student.utils;

public class ResultCode {
	/**
	 * 为方便处理ajax请求
	 */
	public static final int SUCCESS=0;
	
	public static final int FAIL=-1;
	
	public int code=SUCCESS;
	
	public String message="";

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
		System.out.println("MESSAGE:"+message);
	}
	

}
