package com.student.controller.login;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.log.Logger;
import com.student.common.BaseController;
import com.student.constant.CommonConstant;
import com.student.constant.CommonEnum.LogType;
import com.student.dao.UserSession;
import com.student.model.system.SystemAdmin;
import com.student.utils.DateUtil;
import com.student.utils.EncryptUtils;
import com.student.utils.IpUtils;
import com.student.utils.ResultCode;


@ControllerBind(controllerKey="/login")
public class LoginController extends BaseController{
	
	@SuppressWarnings("unused")
	private Logger log=Logger.getLogger(LoginController.class);
	
	/**
	 * 用户登录
	 */
	public void index(){
		String user=getPara("username");
		String password=getPara("password");
		String code=getPara("code");
		String number=(String) this.getSession().getAttribute(CommonConstant.IMAGE_CODE);
		SystemAdmin admin=SystemAdmin.dao.findFirst("select password,encrypt,disabled_flag from system_admin where name=?",user);
		if(admin==null){
			renderJson(new ResultCode(ResultCode.FAIL,"用户不存在"));
			return;
		}else{
			loginSrvice(admin,password,code,number);
			return;
		}
		//rendView("/index.vm");
	}

	/**
	 * 
	 * @param admin
	 * @param password
	 * @param code
	 * @param number
	 */
	private void loginSrvice(SystemAdmin admin, String password, String code,
			String number) {
		if(admin.getStr("password").equals(EncryptUtils.encodePassword(password, admin.getStr("encrypt")))){
			if(admin.getBoolean("disabled_flag")){
				renderJson(new ResultCode(ResultCode.FAIL, "用户已被禁用,请联系管理员"));
				return;
			}else if(!code.equals(number)){
				renderJson(new ResultCode(ResultCode.FAIL, "验证码错误"));
				return;
			}
			loginSuccess(admin);//登录成功
		}
	}

	/**
	 * 登录成功
	 */
	private void loginSuccess(SystemAdmin admin) {
		admin.set("login_time",DateUtil.getDateTime());
		admin.set("login_ip",IpUtils.getAddressIp(getRequest()));
		admin.update();
		UserSession session=new UserSession();
		session.setUserId(admin.getInt("id"));
		session.setLoginName(admin.getStr("login_name"));
		session.setRole_id(admin.getInt("role_id"));
		session.setSuperFlag(admin.getInt("super_flag"));
		session.setLogin_ip(admin.getStr("login_ip"));
		session.setNickName(admin.getStr("nickname"));
		session.setMobile(admin.getStr("mobile"));
		setSessionAttr(CommonConstant.SESSION_ID_KEY, session);
	}
	/**
	 * 用户注销
	 */
	public void exit(){		
		if(getCurrentUser()!=null){
			systemLog(getCurrentUser().getLoginName()+"登出系统",LogType.LOGIN.getValue());
			getRequest().getSession().removeAttribute("user");
			getRequest().getSession().invalidate();//用户注销
			redirect("/",false);
		}
	}

}
