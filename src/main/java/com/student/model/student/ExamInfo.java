package com.student.model.student;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;

@TableBind(tableName="exam_info")
public class ExamInfo extends BaseModel<ExamInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final ExamInfo dao=new ExamInfo();

}
