package com.student.interceptor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
/**
 * 用户session全局拦截器
 * @author Administrator
 *
 */
public class GlobalActionInterceptor implements Interceptor{
	
	static Set<String> noNeedLoginUrl=new HashSet<>();
	/**
	 * 不需要登录就能访问的url
	 */
	public GlobalActionInterceptor(){
		noNeedLoginUrl.add("/");
	}

	@Override
	public void intercept(Invocation inv) {
		HttpServletRequest request=inv.getController().getRequest();
		HttpServletResponse response=inv.getController().getResponse();
		Object object_session=request.getSession().getAttribute("user");
		if(isNeedLogin(inv.getControllerKey(),inv.getActionKey())&&object_session==null){
			try {
				response.sendRedirect(request.getContextPath()+"/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			inv.invoke();
		}
	}

	private boolean isNeedLogin(String controllerKey,String actionKey) {
		if(controllerKey==null){
			return true;
		}
		if(noNeedLoginUrl.contains(controllerKey+"/")||noNeedLoginUrl.contains(actionKey+"/")){
			return false;
		}
		return true;
	}
}
