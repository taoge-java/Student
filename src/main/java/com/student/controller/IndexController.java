package com.student.controller;

import com.jfinal.ext.route.ControllerBind;
import com.student.common.BaseController;
/**
 * 系统首页
 * @author zengjintao
 * @version 1.0
 * @create_at 2017年4月26日 下午4:36:21
 */
@ControllerBind(controllerKey="/")
public class IndexController extends BaseController{

	public void success(){
		rendView("/index.vm");
	}
}
