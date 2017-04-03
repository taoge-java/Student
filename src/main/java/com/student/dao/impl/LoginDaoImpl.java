package com.student.dao.impl;



import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.student.dao.inter.LoginDao;
import com.student.model.system.SystemAdmin;
import com.student.model.system.SystemMenu;
import com.student.utils.Md5Utils;

public class LoginDaoImpl implements LoginDao{
	/**
	 * 用户登录数据层接口实现类
	 * @author Administrator
	 *
	 */
	@Override
	public SystemAdmin getAdmin(String user,String password) {
		SystemAdmin admin = null;
		try {
			admin = SystemAdmin.dao.findFirst("select *from sys_admin where login_name=? and sys_password=?",user,Md5Utils.getMd5(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return admin;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getMenu(int role_id) {
		return SystemMenu.dao.find("select * from sys_menu where role_id=?",role_id);
	}
}
