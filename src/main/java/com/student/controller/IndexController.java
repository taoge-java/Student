package com.student.controller;

import com.jfinal.ext.route.ControllerBind;
import com.student.common.BaseController;
import com.student.utils.Image;
/***
 * 系统首页
 * @author Administrator
 *
 */

@ControllerBind(controllerKey="/")
public class IndexController extends BaseController{

	public void index(){
		render("/WEB-INF/views/login/login.vm");
	}
	
	public void image(){
		Image image=new Image();
		render(image);
	}

}
