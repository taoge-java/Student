package com.student.dao.inter;



import java.util.List;

import com.student.model.system.SystemAdmin;
/**
 * 用户登录数据层接口
 * @author Administrator
 *
 */
public interface LoginDao {
	/**
	 * 查询用户名和密码
	 * @param user
	 * @param password
	 * @return  SystemAdmin
	 */
	public SystemAdmin getAdmin(String user,String password);
	
	/**
	 * 根据role_id查询出用户所拥有的权限
	 * @param role_id
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List getMenu(int role_id);
}
