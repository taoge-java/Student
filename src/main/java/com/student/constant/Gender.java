package com.student.constant;

public enum Gender {
	
	MAN(1, "男"), 
	WOMAN(0,"女");
	private String name;
	private int value;
	private Gender(int value,String name){
		this.name=name;
		this.value=value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
