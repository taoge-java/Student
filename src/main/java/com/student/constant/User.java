package com.student.constant;

public enum User {
	
	YSE(1,"可用"),
	NO(0,"禁用");
	
	int value;
	
	String name;
	
	private  User(int value,String name){
		this.value=value;
		this.name=name;
	}

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
