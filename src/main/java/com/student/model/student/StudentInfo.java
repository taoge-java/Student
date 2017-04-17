package com.student.model.student;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;
@TableBind(tableName="student_info")
public class StudentInfo extends BaseModel<StudentInfo>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final StudentInfo dao=new StudentInfo();
}
