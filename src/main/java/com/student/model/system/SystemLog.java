package com.student.model.system;
import com.jfinal.ext.plugin.tablebind.TableBind;
/***
 * 系统日志表
 */
import com.student.model.BaseModel;
@TableBind(tableName="system_log")
public class SystemLog extends BaseModel<SystemLog>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final SystemLog dao=new SystemLog();

}
