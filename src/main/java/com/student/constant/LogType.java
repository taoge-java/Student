package com.student.constant;

public enum LogType {
	
	LOGIN(1,"登录/登出"),
	DELETE(2,"删除日志"),
	MODIFY(3,"修改/创建");
	
	private LogType(int value,String name){
		this.value=value;
		this.name=name;
	}
	int value;
	
	String name;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
