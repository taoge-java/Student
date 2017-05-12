package com.student.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.student.annotation.Permission;
import com.student.constant.CommonConstant;
import com.student.dao.UserSession;
/**
 * 用户session全局拦截器
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年4月27日 下午1:57:32
 */
public class PermissionInterceptor implements Interceptor{
	
	static Set<String> noNeedLoginUrl=new HashSet<String>();
	/**
	 * 不需要登录就能访问的url
	 */
	public PermissionInterceptor(){
		noNeedLoginUrl.add("/account");
	}

	@Override
	public void intercept(Invocation inv) {
		HttpServletRequest request=inv.getController().getRequest();
		HttpServletResponse response=inv.getController().getResponse();
		Object object_session=request.getSession().getAttribute(CommonConstant.SESSION_ID_KEY);
		if(isNeedLogin(inv.getControllerKey(),inv.getActionKey())&&object_session==null){
			try {
				response.sendRedirect(request.getContextPath()+"/account/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			UserSession session=(UserSession) object_session;
			if(session!=null&&session.isSuperFlag())//是超级管理员
			   inv.invoke();
			else{
				String[] oper={};
				Method method=inv.getMethod();
				Permission permission=method.getAnnotation(Permission.class);
				if(permission!=null&&permission.points()!=null){
					oper=permission.points();
				}
				if(oper!=null&&(oper.length==0||session.hasAnyOper(oper))){
					inv.invoke();
				}else{
					inv.getController().renderJavascript("alert('您的权限不足')");
				}
			}
		}
	}

	private boolean isNeedLogin(String controllerKey,String actionKey) {
		if(controllerKey==null){
			return true;
		}
		if(noNeedLoginUrl.contains(controllerKey)||noNeedLoginUrl.contains(actionKey)){
			return false;
		}
		return true;
	}
}
