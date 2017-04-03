package com.student.model.student;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;
@TableBind(tableName="student_info")
public class Student extends BaseModel<Student>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Student dao=new Student();
}
