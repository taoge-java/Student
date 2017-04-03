package com.student.controller.exam;

/**
 * 学科管理
 * @author Administrator
 *
 */
import com.jfinal.aop.Duang;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.student.common.BaseController;

import com.student.controller.system.AdminController;
import com.student.model.system.SystemSubject;
import com.student.service.student.SubjectServices;
import com.student.utils.ResultCode;
@ControllerBind(controllerKey="/subject")
public class SubjectController extends BaseController{
	
	private SubjectServices subjectServices=Duang.duang(SubjectServices.class.getName(), SubjectServices.class);
    
    Logger log=Logger.getLogger(AdminController.class);
	/**
	 * 列表
	 */
	public void index(){
		Integer pageNumber=getParaToInt("pageNumber", 1);
		Page<SystemSubject> page=subjectServices.getSubject(pageNumber);
		setAttr("page",page);
		rendView("subject/list.jsp");
	}
	/**
	 * 删除学科
	 */
	public void delById(){
		 Integer id=getParaToInt("id");
		 if(id!=null){
			 SystemSubject.dao.deleteById(id);
			 ResultCode result=new ResultCode(ResultCode.SUCCESS,"删除成功");
			 renderJson(result);
			 return ;
		 }else{
			 ResultCode result=new ResultCode(ResultCode.FAIL,"删除数据异常");
			 renderJson(result);
		 }
	 }
	

}
