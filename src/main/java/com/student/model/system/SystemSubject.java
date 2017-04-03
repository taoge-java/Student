package com.student.model.system;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;
@TableBind(tableName="system_subject")
public class SystemSubject extends BaseModel<SystemSubject>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4082886642427725725L;
	
	public static final SystemSubject dao=new SystemSubject();
	
	
	

}
