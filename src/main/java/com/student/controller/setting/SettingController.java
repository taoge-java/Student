package com.student.controller.setting;

import java.security.NoSuchAlgorithmException;


import org.apache.commons.lang.StringUtils;

import com.jfinal.ext.route.ControllerBind;
import com.jfinal.log.Logger;
import com.student.common.BaseController;
import com.student.constant.LogType;
import com.student.model.system.SystemAdmin;
import com.student.utils.Md5Utils;
import com.student.utils.ResultCode;
@ControllerBind(controllerKey="/set")
public class SettingController extends BaseController{
	@SuppressWarnings("unused")
	
	private Logger log=Logger.getLogger(SettingController.class);
	
	
	/**
	 * 修改密码页面
	 */
	public void index(){
		rendView("setting/pass.jsp");
	}
    /**
     * 修改页面
     * @throws NoSuchAlgorithmException 
     */
	public void alterpass() throws NoSuchAlgorithmException{
		String mpass=getPara("mpass");
		String newPass=getPara("newPass");
		String renewpass=getPara("renewpass");
		SystemAdmin admin=SystemAdmin.dao.findFirst("select * from sys_admin where login_name=?",getCurrentUser().getLoginName());
		if(StringUtils.isEmpty(mpass)){
			ResultCode result=new ResultCode(ResultCode.FAIL, "请输入原始密码");
			renderJson(result);
			return;
		}
		if(StringUtils.isEmpty(mpass)){
			ResultCode result=new ResultCode(ResultCode.FAIL, "请输入新密码");
			renderJson(result);
			return;
		}
		if(!newPass.equals(renewpass)){
			ResultCode result=new ResultCode(ResultCode.FAIL, "新密码和确认密码不一致");
			renderJson(result);
			return;
		}
		if(!admin.getStr("sys_password").equals(Md5Utils.getMd5(mpass))){
			ResultCode result=new ResultCode(ResultCode.FAIL, "您的密码输入错误");
			renderJson(result);
			return;
		}
		ResultCode result=new ResultCode(ResultCode.SUCCESS, "密码修改成功,退出后请使用新密码登录!");
		admin.set("sys_password", Md5Utils.getMd5(renewpass));
		admin.update();
		systemLog(getCurrentUser().getLoginName()+"修改密码成功", LogType.MODIFY.getValue());
		renderJson(result);
     }
	

	/**
	* 个人信息设置
    */
	 public void person(){
			
     }
}
