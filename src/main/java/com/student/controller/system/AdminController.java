package com.student.controller.system;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jfinal.aop.Duang;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.student.common.BaseController;
import com.student.constant.LogType;
import com.student.model.system.SystemAdmin;
import com.student.model.system.SystemRole;
import com.student.service.system.AdminServices;
import com.student.utils.Result;
import com.student.utils.ResultCode;

/***
 * 管理员设置
 */
@ControllerBind(controllerKey="/system/admin")
public class AdminController extends BaseController{
	
	private AdminServices adminServices=Duang.duang(AdminServices.class.getName(), AdminServices.class);
	
	private Logger log=Logger.getLogger(AdminController.class);
	/**
	 * 管理员列表
	 */
	@SuppressWarnings("rawtypes")
	public void index(){
		int pageNumber=getParaToInt("pageNumber",1);
		String login_name=getPara("admin.name");
		Page page=adminServices.getAdmin(login_name,pageNumber);
		setAttr("login_name", login_name);
		setAttr("admins", page);
		rendView("system/admin/list.jsp");
	}
	
    /**
     * 添加管理员渲染视图
     */
	public void add(){
		List<SystemRole> list=SystemRole.dao.find("select id, role_name from system_role");
		setAttr("list", list);
		rendView("system/admin/add.jsp");
	}
	/**
	 * 保存管理员
	 */
	public void save(){
		SystemAdmin systemAdmin=new SystemAdmin();
		systemAdmin.getParamters(getParaMap());
		String password=getPara("password");
		String login_name=systemAdmin.getStr("login_name");
		if(StringUtils.isEmpty(login_name)||StringUtils.isEmpty(password)){
			ResultCode resultCode=new ResultCode(ResultCode.FAIL, "登录名或密码不能为空");
			renderJson(resultCode);
			return;
		}
		Result result=adminServices.save(systemAdmin,password);
		systemLog(getCurrentUser().getLoginName()+"成功创建管理员"+systemAdmin.getStr("login_name"),LogType.MODIFY.getValue());
		renderJson(result.getResultCode());
	}
	/**
	 * 删除管理员
	 */
	public void deleteById(){
		Integer id=getParaToInt("id");
		Result result= adminServices.delById(id);
		renderJson(result.getResultCode());
	}
	/**
	 * 修改管理员
	 */
	public void alert(){
		Integer id=getParaToInt(0);
		try{
			if(id>0||id!=null){
			   List<SystemRole> list=SystemRole.dao.find("select id, role_name from system_role");
			   setAttr("list", list);
			   setAttr("admin",adminServices.alert(id));
			   rendView("system/admin/update.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("系统异常");
			renderError(404);
		}
	}
	
	/**
	 * 更新管理员
	 */
	public void update(){
	    int id=	getParaToInt(0);
		SystemAdmin systemAdmin=SystemAdmin.dao.findById(id);
		systemAdmin.getParamters(getParaMap());
		String password=getPara("password");
		if(StringUtils.isEmpty(password)){
			renderJson(new ResultCode(ResultCode.FAIL,"密码不能为空"));
			return;
		}
		Result result=adminServices.update(systemAdmin,password);
		renderJson(result.getResultCode());
	}
	/**
	 * 批量删除管理员
	 */
	public void delAll(){
		String ids=getPara("ids");
		String[] id=ids.split(",");
		Result result=adminServices.delAll(id);
		renderJson(result.getResultCode());
	}
}
