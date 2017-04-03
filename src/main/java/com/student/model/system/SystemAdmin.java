package com.student.model.system;
/**
 * 系统管理员表
 */
import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;

@TableBind(tableName="sys_admin")
public class SystemAdmin extends BaseModel<SystemAdmin>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2457995147027662584L;
	
	public static final SystemAdmin dao=new SystemAdmin();


}
