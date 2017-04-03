package com.student.controller;

import com.jfinal.aop.Clear;
import com.jfinal.ext.route.ControllerBind;
import com.student.common.BaseController;
import com.student.interceptor.GlobalActionInterceptor;
import com.student.utils.Image;
/***
 * 系统首页
 * @author Administrator
 *
 */

@ControllerBind(controllerKey="/")
public class IndexController extends BaseController{
	@Clear(GlobalActionInterceptor.class)
	public void index(){
		rendView("login/login.jsp");
	}
	@Clear(GlobalActionInterceptor.class)
	public void image(){
		Image image=new Image();
		render(image);
	}

}
