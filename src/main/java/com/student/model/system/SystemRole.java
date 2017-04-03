package com.student.model.system;
/**
 * 角色表
 */
import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;
@TableBind(tableName="system_role")
public class SystemRole extends BaseModel<SystemRole>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4821093056423411249L;
	
	public static final SystemRole dao=new SystemRole();


}
