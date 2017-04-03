package com.student.controller.exam;

import java.util.List;


import com.jfinal.aop.Duang;
import com.jfinal.ext.route.ControllerBind;
import com.student.common.BaseController;
import com.student.constant.LogType;
import com.student.model.student.ExamInfo;
import com.student.model.student.Mark;
import com.student.model.system.SystemSubject;
import com.student.service.student.ExamServices;
import com.student.utils.Result;

@ControllerBind(controllerKey="/exam")
public class ExamControler extends BaseController{
	
	private ExamServices examServices=Duang.duang(ExamServices.class.getName(), ExamServices.class);
	@SuppressWarnings("rawtypes")
	public void index(){
    	List list=SystemSubject.dao.find("select  id ,subject_name from system_subject");
		setAttr("list",list);
		//List students=Student.dao.find("select name,number from student_info ");
		List students=Mark.dao.find("select * from student_mark ");
		setAttr("students", students);
    	rendView("exam/info.jsp");
	}
	/**
	 * 保存考试信息
	 */
	public void save(){
		String subject_ids=getPara("subject_ids");
		ExamInfo exam=new ExamInfo();
		exam.getParamters(getParaMap());
	    Result result=examServices.save(exam, subject_ids);
	  	systemLog(getCurrentUser().getLoginName()+"创建考试信息"+exam.getInt("id")+"成功", LogType.MODIFY.getValue());
		renderJson(result.getResultCode());
	}
}
