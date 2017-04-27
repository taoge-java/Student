package com.student.model.system;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;

/**
 * 系统菜单表
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年4月27日 下午3:51:20
 */
@TableBind(tableName="system_menu")
public class SystemMenu extends BaseModel<SystemMenu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final SystemMenu dao=new SystemMenu();

}
