package com.student.constant;

public enum Super {
	
	YSE(1,"是"),
	NO(0,"否");
	
	int value;
	
	String name;
	
	private  Super(int value,String name){
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
