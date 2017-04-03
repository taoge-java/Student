package com.student.model.student;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;
@TableBind(tableName="student_mark")
public class Mark extends BaseModel<Mark>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1697240402867239695L;
	
	public static final Mark dao=new Mark();

}
