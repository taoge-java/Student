package com.student.dao;

import java.util.Iterator;
import java.util.Set;

/**
 * 用户session
 * @author Administrator
 *
 */
public class UserSession {
	
    private int sessionId;//用户sessionId
	
	private int userId;//用户id
	
	private String loginName;//登录名
	
	private String nickName;//昵称
	
	private String realName;//真实姓名
	
	private String mobile;//手机号
	
	public boolean isSuperFlag() {
		return superFlag;
	}

	public void setSuperFlag(boolean superFlag) {
		this.superFlag = superFlag;
	}
	
	private boolean superFlag;//是否超级管理员

	private static Set<String> menuIdSet;

	@SuppressWarnings("rawtypes")
	public Set getMenuIdSet() {
		return menuIdSet;
	}

	@SuppressWarnings("static-access")
	public void setMenuIdSet(Set<String> menuIdSet) {
		this.menuIdSet = menuIdSet;
	}


	
	public static boolean HasId(String id){
	   
		Iterator<String> it=menuIdSet.iterator();
		while(it.hasNext()){
			if(id.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	private String login_time;//登录时间
	

	private String login_ip;//登录ip
	
	private String exit_time;//退出时间

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getExit_time() {
		return exit_time;
	}

	public void setExit_time(String exit_time) {
		this.exit_time = exit_time;
	}
}
