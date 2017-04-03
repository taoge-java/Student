package com.student.service.inter;



import com.student.model.system.RoleMenu;
import com.student.model.system.SystemAdmin;
/**
 * 用户登录services层接�?
 * @author Administrator
 * @
 */
public interface LoginServices {
	/**
	 * 查询用户名和密码
	 * @param user
	 * @param password
	 * @return  SystemAdmin
	 */
	public SystemAdmin getAdmin(String user,String password);
	
	/**
	 * 根据role_id查询出用户所拥有的权�?
	 * @param role_id
	 * @return List
	 */
	public RoleMenu getMenuId(int role_id);
	/**
	 * 查询超级管理员权�?
	 * @return
	 */
}
