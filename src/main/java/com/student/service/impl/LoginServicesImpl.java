package com.student.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.student.dao.impl.LoginDaoImpl;
import com.student.dao.inter.LoginDao;
import com.student.model.system.SystemRole;
import com.student.service.inter.LoginServices;
import com.student.model.system.RoleMenu;
import com.student.model.system.SystemAdmin;
import com.student.model.system.SystemMenu;
/**
 * 用户登录services层接口实现类
 * @author Administrator
 * @
 */
@SuppressWarnings("unused")
public class LoginServicesImpl implements LoginServices{

	private LoginDao loginDao=new LoginDaoImpl();
	
	public SystemAdmin getAdmin(String user,String password) {
		SystemAdmin admin= loginDao.getAdmin(user,password);
		return admin;
	}
	/**
	 * 根据角色id查询�?拥有的功能id
	 */
	@Override
	public RoleMenu getMenuId(int role_id) {
		return null;
//		RoleMenu menuId=RoleMenu.dao.findById(role_id);
//		return menuId;
	}
	
	/**
	 * 查询角色拥有的功�?
	 */
	
	@SuppressWarnings("rawtypes")
	public List getMenu(String ids){
		return SystemMenu.dao.find("select * from Menu where id in("+ids+")");
	}
	/**
	 * menuId集合
	 * @param id
	 * @return
	 */
	public Set<String> getMenuIds(String id[]){
		Set<String> set=new HashSet<String>();
		for(String s:id){
			set.add(s);
		}
		return set;
	}

}
