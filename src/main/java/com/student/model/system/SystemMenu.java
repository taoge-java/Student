package com.student.model.system;
/**
 * 系统后台菜单表
 */
import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;
@TableBind(tableName="sys_menu")
public class SystemMenu extends BaseModel<SystemMenu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1697240402867239695L;
	
	public static final SystemMenu dao=new SystemMenu();

}
