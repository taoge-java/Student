package com.student.model.system;
import java.util.List;

/**
 * 角色功能表
 */
import com.jfinal.ext.plugin.tablebind.TableBind;
import com.student.model.BaseModel;
@TableBind(tableName="role_menu")
public class RoleMenu extends BaseModel<RoleMenu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final RoleMenu dao=new RoleMenu();
	
	@SuppressWarnings("rawtypes")
	public List getMenuByIds(){
		return SystemMenu.dao.find("select * from sys_menu where id in("+getStr("menu_id")+"");
	}
}
