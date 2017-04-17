package com.student.controller.login;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Duang;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.log.Logger;
import com.student.common.BaseController;
import com.student.constant.LogType;
import com.student.constant.User;
import com.student.dao.UserSession;
import com.student.interceptor.GlobalActionInterceptor;
import com.student.model.system.SystemAdmin;
import com.student.service.impl.LoginServicesImpl;
import com.student.service.inter.LoginServices;
import com.student.spring.SpringBeanManger;
import com.student.utils.DateUtil;
import com.student.utils.IpUtils;
import com.student.utils.ResultCode;


@ControllerBind(controllerKey="/login")
public class LoginControl extends BaseController{
	
	@SuppressWarnings("unused")
	private Logger log=Logger.getLogger(LoginControl.class);
	
	@SuppressWarnings("unused")
	private LoginServicesImpl loginServices=Duang.duang(LoginServicesImpl.class.getName(), LoginServicesImpl.class);
	
	/**
	 * 用户成功登录
	 */
	
	public void index(){
	}
	public void success(){
		rendView("index/index.jsp");
	}
	

	/**
	 * 用户登录ajax校验֤
	 */

	@Clear(GlobalActionInterceptor.class)
	public void login(){
		String user=getPara("username");
		String password=getPara("password");
		String Code=getPara("code");
		String number=(String) this.getSession().getAttribute("imagecheck");
		SystemAdmin admin=services.getAdmin(user,password);
	    if(!Code.equals(number)){
	    	ResultCode result=new ResultCode(ResultCode.FAIL, "验证码错误!");
			renderJson(result);
			return;
		}
		if(admin!=null&&Code.equals(number)){
			if(admin.getInt("disabled_flag")!=User.YSE.getValue()){
				ResultCode result=new ResultCode(ResultCode.FAIL, "账号已被禁用");
				renderJson(result);
				return;
			}else{
				//render(new JsonRender("{\"code\":2,\"message\":\"登录成功\"}"));
				admin.set("login_time",DateUtil.getDateTime());
				admin.set("login_ip",IpUtils.getAddressIp(getRequest()));
				admin.update();
				UserSession session=new UserSession();
				session.setUserId(admin.getInt("id"));
				session.setLoginName(user);
				session.setRole_id(admin.getInt("role_id"));
				session.setSuperFlag(admin.getInt("super_flag"));
				session.setLogin_ip(admin.getStr("login_ip"));
				session.setNickName(admin.getStr("nickname"));
				session.setMobile(admin.getStr("mobile"));
				setSessionAttr("user", session);
				/**
				 * 非管理员用户加载权限
				 */
			//	if(!session.isSuperFlag()){
//					RoleMenu role=loginServices.getMenuId(session.getRole_id());
//					String ids=role.getStr("menu_id");
//					String[] id=StringUtils.split(ids, ",");
//					getCurrentUser().setMenuIdSet(loginServices.getMenuIds(id));
				//}
				ResultCode result=new ResultCode(ResultCode.SUCCESS, "登录成功");
				systemLog(user+"登录",LogType.LOGIN.getValue());
				renderJson(result);
				}
		}else{
			ResultCode result=new ResultCode(ResultCode.FAIL, "用户名或密码错误!");
			renderJson(result);
			return;
		}
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
